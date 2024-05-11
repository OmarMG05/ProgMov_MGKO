package com.example.listasyspinnersmgko

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtSelectYourCountry = findViewById<TextView>(R.id.txtViewSelectYourCountry)//Se le asigna a la variable txtSelectYourCountry el texto del txtViewSelectYourCountry del activity_main
        val countrySpinner = findViewById<Spinner>(R.id.spinnerCountryList)//busca el spinner por su "Id/Nombre" dentro de el activity_main y se lo asigna a countrySpinner
        val nextButton = findViewById<Button>(R.id.buttonNext)//Se le asigna a la variable nextButton el buttonNext del activity_main

        // Configuración de la lista de países
        val countries = arrayOf("USA","México","Brasil", "France","Deutschland","Italia")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries) //adapter para el Spinnee
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)//setea el diseño del spinner
        countrySpinner.adapter = adapter//Se le asigna el adapter al spinner


        // Asignar el evento onItemSelectedListener al Spinner de países
        countrySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                // Obtener el país seleccionado en el Spinner
                val selectedCountry = parent?.getItemAtPosition(position).toString()

                // Cambiar el idioma según el país seleccionado
                when (selectedCountry) {
                    "USA" -> {
                        //Cambiar el texto del botón "Next" y "Select your country" a inglés
                        nextButton.text = getString(R.string.next_en)
                        txtSelectYourCountry.text = getString(R.string.select_country_en)
                    }
                    "México" -> {
                        // Cambiar el texto del botón "Next" y "Select your country" a español
                        nextButton.text = getString(R.string.next_es)
                        txtSelectYourCountry.text = getString(R.string.select_country_es)
                    }
                    "Brasil" -> {
                        // Cambiar el texto del botón "Next" y "Select your country" a portugués
                        nextButton.text = getString(R.string.next_pt)
                        txtSelectYourCountry.text = getString(R.string.select_country_pt)
                    }
                    "France" ->{
                        // Cambiar el texto del botón "Next" y "Select your country" a francés
                        nextButton.text = getString(R.string.next_fr)
                        txtSelectYourCountry.text = getString(R.string.select_country_fr)
                    }
                    "Deutschland" ->{
                        // Cambiar el texto del botón "Next" y "Select your country" a francés
                        nextButton.text = getString(R.string.next_de)
                        txtSelectYourCountry.text = getString(R.string.select_country_de)
                    }
                    "Italia" ->{
                        // Cambiar el texto del botón "Next" y "Select your country" a francés
                        nextButton.text = getString(R.string.next_it)
                        txtSelectYourCountry.text = getString(R.string.select_country_it)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                nextButton.text = getString(R.string.next_en)
                txtSelectYourCountry.text = getString(R.string.select_country_en)
            }
        }

        // Asignar el evento onClick al botón "Next"
        nextButton.setOnClickListener {
            // Obtener el país seleccionado en el Spinner y lo convierte a String
            val selectedCountry = countrySpinner.selectedItem.toString()

            // Determinar el idioma según el país seleccionado
            val languageCode = when (selectedCountry) {
                "USA" -> "en"
                "México" -> "es"
                "Brasil" -> "pt"
                "France"-> "fr"
                "Deutschland"-> "de"
                "Italia"-> "it"
                else -> "en"
            }
            // Cambiar el idioma de la aplicación
            changeAppLanguage(languageCode)

            // Mostrar un AlertDialog con un mensaje de bienvenida en el idioma seleccionado
            val welcomeMessage = when (languageCode) {
                "en" -> "Welcome!"
                "es" -> "¡Bienvenido!"
                "pt" -> "Bem-vindo!"
                "fr" -> "Bienvenue!"
                "de" -> "Willkommen!"
                "it" -> "Benvenuto!"
                else -> "Welcome!"
            }
            val alertDialogBuilder = AlertDialog.Builder(this@MainActivity)
            alertDialogBuilder.setMessage(welcomeMessage)
            alertDialogBuilder.setCancelable(false) // Evita que el AlertDialog se cierre al tocar fuera de él
            alertDialogBuilder.setPositiveButton("OK") {dialog, _ ->
                //Cierra el Alert al hacer clic en "Ok"
                dialog.dismiss()
                // Recrear la actividad para aplicar los cambios de idioma después de cerrar el diálogo
                recreate()
            }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }
    // Función para cambiar el idioma de la aplicación
    fun changeAppLanguage(languageCode: String) {
        val locale = Locale(languageCode)//se crea un objeto Locale utilizando el código de idioma proporcionado. Este objeto Locale representa el idioma al que se cambiará la aplicación.
        Locale.setDefault(locale)//establece el objeto locale como la configuración de idioma predeterminada para la aplicación.
        val configuration = Configuration()//Se crea un objeto Configuration, que se utiliza para configurar la configuración de la aplicación, como el idioma y otras configuraciones específicas del dispositivo.
        configuration.locale = locale//se establece el idioma en el objeto configuration utilizando el Locale
        baseContext.resources.updateConfiguration(configuration, baseContext.resources.displayMetrics)//actualiza la configuración de recursos de la aplicación con la nueva configuración de idioma.
    }
}
