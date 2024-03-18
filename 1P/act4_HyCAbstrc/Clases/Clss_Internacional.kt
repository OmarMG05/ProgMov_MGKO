package Practicas_Clases

//1. Creación de la clase International para viajes internacionales
class Clss_International(override val pais: String, override val ciudad: String): Clss_ReservarViaje() {
    //3. Mapa de impuestos por país
    protected val impuestos = mapOf(
        "Alemania" to 0.16,
        "Chile" to 0.05,
        "Canadá" to 0.1
    )

    protected val tarifas = mapOf(
        "Alemania" to mapOf(
            "Munich" to 980,
            "Berlín" to 820,
            "Francfort" to 850
        ),
        "Chile" to mapOf(
            "Santiago" to 643,
            "Valparaíso" to 721
        ),
        "Canadá" to mapOf(
            "Vancouver" to 620,
            "Ottawa" to 680,
            "Montreal" to 600
        )
    )

    //4. Se modificó la funcion de obtenerPrecio para obtener precio con impuesto incluído
    override fun obtenerPrecio(numDias: Int): Double {
        val tarifa = tarifas[pais]?.get(ciudad)
        return if (tarifa == null) 0.0 else (tarifa * numDias) * (1 + impuestos[pais]!!)
    }

    override fun cotizarPrecio(numDias: Int) {
        val precio = obtenerPrecio(numDias)
        if (precio == 0.0) {
            println("Lo sentimos, no hacemos viajes a este país o ciudad.")
        } else {
            println("Tu viaje a $ciudad, $pais cuesta \$$precio")
        }
    }
}
