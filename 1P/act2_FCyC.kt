fun main() {
    println("Pruebas de esc PUNTO 1.")
    println("El area del rectangulo es: ${areaRect(90.0,40.0)} cm2")
    println("El area del rectangulo es: ${areaRect(87.0,68.0)} cm2\n")

    println("Pruebas de esc PUNTO 2.")
    println("El volumen del prisma rectangular es: ${volPrismRect(2.0)} cm3\n")

    println("Pruebas de esc PUNTO 3 y 4.")
    println("El promedio de calificacion es: ${promedio(tresP = 10f)}\n")

    println("Pruebas de esc PUNTO 5.")
    tipoTriang()
    println("\n")

    println("Pruebas de esc PUNTO 6.")
    tipoDato("Hola Mundo")
    tipoDato(5)
    tipoDato(5.77)
    tipoDato(true)
    tipoDato('a')
    println("\n")

    println("Pruebas de esc PUNTO 7.")
    cuentaNom()
}
    //1. Area de rectangulo
    fun areaRect(b:Double,h:Double):Double{
        return b*h
    }
    //2. Volumen de PrismaRectangular utilizando la funcion del punto 1.
    fun volPrismRect(a:Double):Double{
        return areaRect(30.0,55.0)*a
    }
    //3. Funcion promedio con valor por defecto de 8 en 1er y 2do parcial
    fun promedio(unoP:Float=8f,dosP:Float=8f,tresP:Float):Float{
        return ((unoP+dosP+tresP)/3)
    }
    //5.
    fun tipoTriang(){
        print("Ingrese el valor del lado 1 (escriba únicamente el número): ")
        val lado1 = readLine()?.toDouble()
        print("Ingrese el valor del lado 2 (escriba únicamente el número): ")
        val lado2 = readLine()?.toDouble()
        print("Ingrese el valor del lado 3 (escriba únicamente el número): ")
        val lado3 = readLine()?.toDouble()
        //equilatero
        if(lado1==lado2 && lado1==lado3){
            println("El triangulo es equilatero (sus 3 lados iguales)")
        //isóceles
        }else if(lado1==lado2 || lado1==lado3 || lado2==lado3){
            println("El triangulo es isóceles (2 lados iguales)")
        //escaleno
        } else{
            println("El triangulo es escaleno (todos sus lados diferentes)")
        }
    }
    //6.
    fun tipoDato(dato:Any){
        when(dato){
            is String -> println("El dato ($dato) es una Cadena(String).")
            is Int -> println("El dato $dato es un numero Entero(Int)")
            is Double -> println("El dato $dato es un numero Double")
            else -> println("Otro tipo de dato: ${dato::class.simpleName}")
        }
    }
    //7.
    fun cuentaNom(){
        val lista = listOf("Pedro Luis", "Juan Manuel", "Juan Luis", "María Inés", "Romeo", "Ernesto", "Juan Pedro", "Ariadna", "Mireya María", "Ana Sofía", "José Juan")
        print("Ingrese el nombre que desea contabilizar:")
        val nombre= readLine()
        println("El nombre ($nombre) se repite ${lista.count{it.contains("$nombre")}} veces\n")
        println("Conteo de TODOS los nombres, uno por uno")
        println("El nombre (Pedro) se repite ${lista.count{it.contains("Pedro")}} veces")
        println("El nombre (Luis) se repite ${lista.count{it.contains("Luis")}} veces")
        println("El nombre (Juan) se repite ${lista.count{it.contains("Juan")}} veces")
        println("El nombre (Manuel) se repite ${lista.count{it.contains("Manuel")}} veces")
        println("El nombre (María) se repite ${lista.count{it.contains("María")}} veces")
        println("El nombre (Inés) se repite ${lista.count{it.contains("Inés")}} veces")
        println("El nombre (Romeo) se repite ${lista.count{it.contains("Romeo")}} veces")
        println("El nombre (Ernesto) se repite ${lista.count{it.contains("Ernesto")}} veces")
        println("El nombre (Ariadna) se repite ${lista.count{it.contains("Ariadna")}} veces")
        println("El nombre (Mireya) se repite ${lista.count{it.contains("Mireya")}} veces")
        println("El nombre (Ana) se repite ${lista.count{it.contains("Ana")}} veces")
        println("El nombre (Sofía) se repite ${lista.count{it.contains("Sofía")}} veces")
        println("El nombre (José) se repite ${lista.count{it.contains("José")}} veces")
    }
