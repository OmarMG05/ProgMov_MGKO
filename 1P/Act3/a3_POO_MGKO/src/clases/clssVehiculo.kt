package clases

class clssVehiculo{
    var color:String=""
    var marca:String=""
    var modelo:String=""
    var placas:String=""
    var estado:Boolean=false
    var gasolina:Int=0

    fun encender() {
        estado = true
        println("\nVehículo encendido\n")
    }

    fun apagar() {
        estado = false
        println("\nVehículo apagado\n")
    }

    fun recargar() {
        gasolina += 10
        println("Se recargaron 10Lt de gasolina")
        println("El tanque cuenta con $gasolina Lt de gasolina")
    }

    fun info(){
        println("\n**Estado del vehículo:**")
        println("Color: $color")
        println("Marca: $marca")
        println("Modelo: $modelo")
        println("Placas: $placas")
        println("Encendido: ${if (estado) "Sí" else "No"}")
        println("Gasolina: $gasolina litros\n")
    }
}