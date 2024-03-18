package Practicas_Interfaces

interface Intrfc_Descuento {
    val descuento: Int //el descuento en porcentaje o en cantidad
    val tipoDescuento: Int //porcentaje o cantidad

    fun obtenerPrecioConDescuento(monto: Double): Double{ //obtener el precio real ya con el descuento
        return if(tipoDescuento == 0) { //0 es porcentaje
            (monto * (100-descuento))/100
        } else{ //cantidad específica
            monto - descuento
        }
    }
}
