package Practicas_Clases

abstract class Clss_ReservarViaje {
    abstract val pais: String
    abstract val ciudad: String
    protected val tipoServicio = "Viaje"
    protected var reservado = false
    protected var montoPagado = 0.0

    fun reservar(numDias: Int) {
        if (reservado) {
            println("""¡Ya reservaste tu viaje! 
                       País: $pais
                       Ciudad: $ciudad
                       Precio: $montoPagado""".trimMargin())
            return
        }
        val monto = obtenerPrecio(numDias)
        if (monto == 0.0) {
            return
        }
        reservado = true
        montoPagado = monto
        println("""¡Viaje reservado exitosamente! 
                       País: $pais
                       Ciudad: $ciudad
                       Precio: $montoPagado""".trimMargin())
    }

    protected abstract fun obtenerPrecio(numDias: Int): Double

    abstract fun cotizarPrecio(numDias: Int)
}