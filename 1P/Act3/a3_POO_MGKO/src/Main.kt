import clases.Clss_person
import clases.clssVehiculo

fun main() {
    val miVehiculo = clssVehiculo()
    miVehiculo.color="Vino"
    miVehiculo.marca="Chevrolet"
    miVehiculo.modelo="Corvette"
    miVehiculo.placas="5MGKO5"
    miVehiculo.info()
    miVehiculo.encender()
    miVehiculo.apagar()
    miVehiculo.recargar()
    miVehiculo.recargar()
    miVehiculo.info()

    val usuario = Clss_person("Kevin Omar","Marín González","Masculino",1.89f)
}
