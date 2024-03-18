package Practicas_Clases

import kotlin.time.times

open class Clss_Nacional(override val ciudad: String): Clss_ReservarViaje() {
    override val pais = "México"

    protected val tarifas = mapOf(
        "Monterrey" to 400,
        "Guadalajara" to 350,
        "CDMX" to 360,
        "San Cristóbal de las casas" to 240,
        "San Miguel de Allende" to 320
    )

    override fun obtenerPrecio(numDias: Int): Double {
        val tarifa = tarifas[ciudad]
        return if (tarifa == null) 0.0 else (tarifa * numDias).toDouble()
    }

    override fun cotizarPrecio(numDias: Int) {
        val precio = obtenerPrecio(numDias)
        if (precio == 0.0) {
            println("Lo sentimos, no hacemos viajes a esta ciudad")
        } else {
            println("Tu viaje a $ciudad cuesta \$$precio")
        }
    }
}
