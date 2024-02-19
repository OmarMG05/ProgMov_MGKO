    /*
    Marín González Kevin Omar
    Programación Móvil 6NM61
    Actividad 1. Variables y Tipos de Datos
    */

    var numDec = 5.123456789987654 //1. Por defecto un decimal se imprime como double
    var numDecFlot = 5.123456789987654f //La variable se vuelve flotante sí le agregamos una "f" al final
    const val PI = 3.1416
    //1.
    fun uno(){
        println("Esto es una variable decimal (por defecto double) $numDec")
    }
    //2.
    fun dos(){
        println("Esto es una variable decimal convertida a flotante $numDecFlot")
    }
    //3.
    fun circPerim(){
        //4.
        println("El perimetro del circulo es ${PI*2*numDecFlot}") //String Template para imprimir el perimetro
    }
    // 5. Ecuación de la pendiente m = (y2 - y1) / (x2 - x1) con operadores
    // 6. Calcular la pendiente m para P1(4,3) y P2(-3,-2)
    fun pendiente() {
        var x1 = 4.0
        var y1 = 3.0
        var x2 = -3.0
        var y2 = -2.0

        /* 7. El resultado obtenido difiere del resultado esperado porque por defecto toma "m" como
        un dato de tipo entero y no toma en cuenta los decimales, enviando únicamente el valor de 0*/
        var m = (y2 - y1)/(x2 - x1)
        /* 8. Sí agregamos ".0" despues de los valores de las x y y, Kotlin ahora si, ya interpreta que se está trabajando con
        doubles e imprime el resultado correcto*/
        println("La pendiente m = $m")
    }

    //FUNCIÓN PRINCIPAL
    fun main(){
        uno()
        dos()
        circPerim()
        pendiente()
    }
