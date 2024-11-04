import java.io.File

const val GREEN = "\u001B[32m"
const val BG_GREEN = "\u001B[42m"
const val BG_YELLOW = "\u001B[43m"

fun seleccionJugador(seleccion: String):String{
    val seleccionOpcionJugador= readln()
    return seleccionOpcionJugador
}
fun jugar(seleccion: String):String{
    val seleccion= "1"
    if (seleccion == "1") true
    return seleccion
}

fun variableEscrita(number:String):Unit{
    val entrada = readln().split("")
    val num1 = entrada[0].toInt()
    val num2 = entrada[1].toInt()
    val num3 = entrada[2].toInt()
    val num4 = entrada[3].toInt()
    if (num1 in 0..9) {
        true
    } else if (num2 in 0..9){
        true
    } else if (num3 in 0..9 ) {
        true
    } else if (num4 in 0..9) {
        true
    } else {
        false
    }
    var numeroCompleto="$num1$num2$num3$num4"
    return println(numeroCompleto)
}

fun traza( number: String):Int{
    val traza=2
    return traza
}
fun salir(number: String):Int{
    val salir=3
    return salir
}
fun main() {


    //Seccion de Menu-----------------
    println("${GREEN}" + jugar("1")+ ". Jugar")
    println("${GREEN}2. Ver traza de último intento")
    println("${GREEN}3. Salir")
    print("${GREEN}opcion: ")
    print(seleccionJugador(readln()))
    if (seleccionJugador("1") == jugar("1")) {
        for (i in 0 until 10) {
            //Solicitud de Numero-------------
            print("teclea un número de 4 cifras sin numeros repetidos: ")
            print(variableEscrita(readln()))
            //Numero Aleatorio del Sistema----
            var l = (1..6).toList()
            l = l.shuffled()
            println(l)
            var numSecreto = ""
            for (i in 0 until 4) {
                numSecreto += l[i]
            }
            println(numSecreto)
        }
    }


    //Fichero-------------------------
    //val content = File("mifichero.txt").appendText()
}