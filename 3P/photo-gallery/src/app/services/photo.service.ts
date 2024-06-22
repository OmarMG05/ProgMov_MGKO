import { Injectable } from '@angular/core';
import { Camera, CameraResultType, CameraSource, Photo } from '@capacitor/camera';
import { Capacitor } from '@capacitor/core';
import { Directory, Filesystem } from '@capacitor/filesystem';
import { Preferences } from '@capacitor/preferences';
import { Platform } from '@ionic/angular';

@Injectable({
  providedIn: 'root',
})
export class PhotoService {
  public photos: UserPhoto[] = [];
  private PHOTO_STORAGE: string = 'photos';

  constructor(private platform: Platform) {
    this.platform.ready().then(() => {
      this.loadSaved().catch(console.error);
    });
  }

  public async loadSaved() {
    try {
      const photoList = await Preferences.get({ key: this.PHOTO_STORAGE });
      this.photos = photoList.value ? JSON.parse(photoList.value) : [];

      if (!this.platform.is('hybrid')) {
        for (let photo of this.photos) {
          const readFile = await Filesystem.readFile({
            path: photo.filepath,
            directory: Directory.Data,
          });
          photo.webviewPath = `data:image/jpeg;base64,${readFile.data}`;
        }
      }
    } catch (error) {
      console.error('Error loading saved photos', error);
    }
  }

  public async addNewToGallery() {
    try {
      const capturedPhoto = await Camera.getPhoto({
        resultType: CameraResultType.Uri,
        source: CameraSource.Camera,
        quality: 100,
      });

      const savedImageFile = await this.savePicture(capturedPhoto);
      this.photos.unshift({
        filepath: savedImageFile.filepath,
        webviewPath: savedImageFile.webviewPath || '' // Proporciona un valor predeterminado si es undefined
      });      

      await Preferences.set({
        key: this.PHOTO_STORAGE,
        value: JSON.stringify(this.photos),
      });
    } catch (error) {
      console.error('Error adding new photo to gallery', error);
    }
  }

  private async savePicture(photo: Photo) {
    try {
      const base64Data = await this.readAsBase64(photo);
      const fileName = new Date().getTime() + '.jpeg';
      const savedFile = await Filesystem.writeFile({
        path: fileName,
        data: base64Data,
        directory: Directory.Data,
      });

      if (this.platform.is('hybrid')) {
        return {
          filepath: savedFile.uri,
          webviewPath: Capacitor.convertFileSrc(savedFile.uri),
        };
      } else {
        return {
          filepath: fileName,
          webviewPath: photo.webPath,
        };
      }
    } catch (error) {
      console.error('Error saving picture', error);
      throw error;
    }
  }

  private async readAsBase64(photo: Photo) {
    try {
      if (this.platform.is('hybrid')) {
        const file = await Filesystem.readFile({
          path: photo.path || '' // Proporciona un valor predeterminado si es undefined
        });
        return file.data;
      } else {
        const response = await fetch(photo.webPath!);
        const blob = await response.blob();
        return (await this.convertBlobToBase64(blob)) as string;
      }
    } catch (error) {
      console.error('Error reading photo as base64', error);
      throw error;
    }
  }

  public async deletePicture(photo: UserPhoto, position: number) {
    try {
      this.photos.splice(position, 1);

      await Preferences.set({
        key: this.PHOTO_STORAGE,
        value: JSON.stringify(this.photos),
      });

      const filename = photo.filepath.substr(photo.filepath.lastIndexOf('/') + 1);
      await Filesystem.deleteFile({
        path: filename,
        directory: Directory.Data,
      });
    } catch (error) {
      console.error('Error deleting picture', error);
    }
  }

  convertBlobToBase64 = (blob: Blob) =>
    new Promise((resolve, reject) => {
      const reader = new FileReader();
      reader.onerror = reject;
      reader.onload = () => {
        resolve(reader.result);
      };
      reader.readAsDataURL(blob);
    });
}

export interface UserPhoto {
  filepath: string;
  webviewPath: string;
}
