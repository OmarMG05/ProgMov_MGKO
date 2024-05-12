package com.example.recyclerviewmgko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombreJuegos = arrayOf(
            getString(R.string.nomJ1),
            getString(R.string.nomJ2),
            getString(R.string.nomJ3),
            getString(R.string.nomJ4),
            getString(R.string.nomJ5),
            getString(R.string.nomJ6),
            getString(R.string.nomJ7)
        )

        // Asignar calificaciones a cada juego
        val calificacionJuego1 = 4.5f
        val calificacionJuego2 = 4.7f
        val calificacionJuego3 = 4f
        val calificacionJuego4 = 5f
        val calificacionJuego5 = 3.7f
        val calificacionJuego6 = 4.5f
        val calificacionJuego7 = 3.5f

        // Array con las calificaciones de los juegos
        val calificaciones = arrayOf(
            calificacionJuego1,
            calificacionJuego2,
            calificacionJuego3,
            calificacionJuego4,
            calificacionJuego5,
            calificacionJuego6,
            calificacionJuego7
        )

        // Determinar el juego con la calificación más alta
        var calificacionMax = 0.0f
        var nombreJuegoMaxCalificacion = ""
        for (i in 0 until calificaciones.size) {
            if (calificaciones[i] > calificacionMax) {
                calificacionMax = calificaciones[i]
                nombreJuegoMaxCalificacion = "${nombreJuegos[i]} con $calificacionMax estrellas"
            }
        }

        val mensaje = "El juego con la calificación más alta es $nombreJuegoMaxCalificacion"
        val toast = Toast.makeText(applicationContext, mensaje, Toast.LENGTH_LONG)
        toast.show()

        // Llenar las RatingBar con la calificación de cada juego
        val rbCalificacionJ1 = findViewById<RatingBar>(R.id.rbCalificacionJ1)
        val rbCalificacionJ2 = findViewById<RatingBar>(R.id.rbCalificacionJ2)
        val rbCalificacionJ3 = findViewById<RatingBar>(R.id.rbCalificacionJ3)
        val rbCalificacionJ4 = findViewById<RatingBar>(R.id.rbCalificacionJ4)
        val rbCalificacionJ5 = findViewById<RatingBar>(R.id.rbCalificacionJ5)
        val rbCalificacionJ6 = findViewById<RatingBar>(R.id.rbCalificacionJ6)
        val rbCalificacionJ7 = findViewById<RatingBar>(R.id.rbCalificacionJ7)

        rbCalificacionJ1.rating = calificacionJuego1
        rbCalificacionJ2.rating = calificacionJuego2
        rbCalificacionJ3.rating = calificacionJuego3
        rbCalificacionJ4.rating = calificacionJuego4
        rbCalificacionJ5.rating = calificacionJuego5
        rbCalificacionJ6.rating = calificacionJuego6
        rbCalificacionJ7.rating = calificacionJuego7
    }
}