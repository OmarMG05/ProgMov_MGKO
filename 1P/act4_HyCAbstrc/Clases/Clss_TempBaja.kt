package Practicas_Clases

import Practicas_Interfaces.Intrfc_CancelarViaje
import Practicas_Interfaces.Intrfc_Descuento
//5. Se implementa la interfaz para cencelar viajes
class Clss_TempBaja (ciudad: String) : Clss_Nacional(ciudad), Intrfc_Descuento, Intrfc_CancelarViaje {
    override val descuento = 10 //es porcentaje, o sea 10%
    override val tipoDescuento = 0 //0 para porcentaje, 1 para cantidad
    override fun obtenerPrecio(numDias: Int): Double {
        val monto = super.obtenerPrecio(numDias)
        return if (monto == 0.0) 0.0 else obtenerPrecioConDescuento(monto).toDouble()
    }
    override fun cancelar(): String {
        if (!reservado) {
            return "No se ha realizado ninguna reserva para cancelar."
        }
        reservado = false
        montoPagado = 0.0
        return "¡Viaje cancelado exitosamente!"
    }
}
