import Practicas_Clases.Clss_International
import Practicas_Clases.Clss_Nacional
import Practicas_Clases.Clss_TempBaja

fun main() {
    // Prueba de clase Clss_Nacional
    val viajeNacional = Clss_Nacional("Monterrey")
    viajeNacional.cotizarPrecio(5)

    // Prueba de clase Clss_TempBaja
    val viajeTempBaja = Clss_TempBaja("San Miguel de Allende")
    viajeTempBaja.cotizarPrecio(7)
    viajeTempBaja.reservar(7)
    println(viajeTempBaja.cancelar())

    // Prueba de clase Clss_International
    val viajeInternacional = Clss_International("Alemania", "Munich")
    viajeInternacional.cotizarPrecio(10)
}
