package com.example.reto02mgko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    private lateinit var btnAccept: Button
    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText
    private lateinit var authResultImageView:ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAccept = findViewById(R.id.btnAccept)
        editText = findViewById(R.id.editText)
        editText2 = findViewById(R.id.editText2)
        editText3 = findViewById(R.id.editText3)
        editText4 = findViewById(R.id.editText4)
        authResultImageView = findViewById(R.id.authResultImageView)

        btnAccept.setOnClickListener{

            val isEmpty = editText.text.isEmpty() || editText2.text.isEmpty() || editText3.text.isEmpty() || editText4.text.isEmpty()
            if (isEmpty) {
                authResultImageView.setImageResource(R.drawable.cross)
                // Deshabilitar el botón
                btnAccept.isEnabled = false
                // Ocultar el botón
                btnAccept.visibility = View.INVISIBLE
                Timer("HideSuccessImage", false).schedule(2400) {
                    runOnUiThread {
                        authResultImageView.visibility = View.INVISIBLE
                        // habilitar DE NUEVO el botón
                        btnAccept.isEnabled = true
                        // Ocultar el botón
                        btnAccept.visibility = View.VISIBLE
                    }
                }
            } else {
                authResultImageView.setImageResource(R.drawable.check)
                Toast.makeText(this, "Datos enviados correctamente", Toast.LENGTH_SHORT).show()
            }
            // Mostrar la imagen del resultado de la autenticación
            authResultImageView.visibility = View.VISIBLE


            if (isEmpty) {
                // Mostrar mensaje de error si algún campo está vacío
                Toast.makeText(this, "Complete todos los campos para continuar", Toast.LENGTH_SHORT).show()
            } else {
                // Limpiar los EditText si los campos no están vacíos
                editText.text.clear()
                editText2.text.clear()
                editText3.text.clear()
                editText4.text.clear()

                // Deshabilitar el botón
                btnAccept.isEnabled = false
                // Ocultar el botón
                btnAccept.visibility = View.INVISIBLE
            }
        }
    }
}
