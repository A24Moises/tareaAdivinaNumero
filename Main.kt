import kotlin.random.Random
import java.io.File
//Colores--------------------------------------------------
const val PURPLE = "\u001B[35m"
const val GREEN = "\u001B[32m"
const val YELLOW = "\u001B[33m"
const val RED = "\u001B[31m"
const val CYAN = "\u001B[36m"
const val WHITE = "\u001B[37m"
const val BLACK = "\u001B[30m"
//Estilo----------------------------------------------------
const val RESET = "\u001B[0m"
const val UNDERLINE = "\u001B[4m"
const val BOLD = "\u001B[1m"
//Color_Fondo-----------------------------------------------
const val BG_YELLOW = "\u001B[43m"
const val BG_RED = "\u001B[41m"
const val BG_GREEN = "\u001B[42m"
const val BG_BLACK = "\u001B[40m"
//---------------------------------------------------------

fun main() {
    val maxJugadas = 10
    val nombreFichero = "ultimo_Historico_Juego.txt"
    val numIncog = numIncogCreado()
    var intentos= mutableListOf<String>()
    var numSelec:Int= 0

    while (numSelec != 3) {
        println("${YELLOW}|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|")
        println("${YELLOW}        *\n"+
                "       * *\n" +
                "      * * *\n" +
                "     * * * *\n" +
                "    * * * * *")
        println("${PURPLE}${UNDERLINE}${BOLD}ADIVINA EL NUMERO${RESET}")
        println("${YELLOW}    * * * * * \n"+
                "     * * * *\n"+
                "      * * *\n"+
                "       * *\n"+
                "        *")
        println()
        println("${YELLOW}${BG_BLACK} 1.${RESET}${GREEN}  Jugar")
        println("${YELLOW}${BG_BLACK} 2.${RESET}${GREEN}  Ver Historico del Ultimo Intento")
        println("${YELLOW}${BG_BLACK} 3.${RESET}${GREEN}  Salir")
        println("${YELLOW}|_____________________________________|")
        println()
        print("${GREEN}      Escriba el Nº de Opción: ")
        numSelec= readln().toIntOrNull() ?: 0
        println()
        println("${YELLOW} _____________________________________________")
        println()

        when (numSelec) {
            1 -> {
                intentos = mutableListOf()
                println("${CYAN}      Iniciando un nuevo juego:")
                println()
                println("${CYAN}     - Debes adivinar un número de 4 dígitos, \n       sin que se repitan y esten entre 1 y 6.")
                println("${CYAN}     - Maximo de 10 intentos por partida.")
                println("${YELLOW} _____________________________________________")
                println()

                for (jugadas in 1..maxJugadas) {
                    print("${CYAN}      Intento ${PURPLE}$jugadas ${CYAN}: Teclea un número de 4 digitos \n      sin números repetidos: ${RESET}")
                    val posible = readln()?.trim()
                    println("${YELLOW} _____________________________________________")
                    println()

                    if (posible == null || posible.length != 4 || !posible.all { it in '1'..'6' } || numRepetidos(posible)) {
                        println("${RED}      -X- Número inválido.\n          Intenta de nuevo.")
                        println("${YELLOW} _____________________________________________")
                        println()
                        continue
                    }

                    val (aciertos, posibles) = evaluarAcierto(posible, numIncog)
                    intentos.add("      Intento $jugadas: $posible, Aciertos: $aciertos, Coincidencias: $posibles")

                    if (aciertos == 4) {
                        println("${RESET}    ${BG_GREEN}  ${RESET}${PURPLE}${BG_BLACK}¡Felicidades!${RESET}${BG_GREEN}  ${RESET}")
                        println("${CYAN}      Has adivinado el número secreto: $numIncog en $jugadas intentos.${RESET}")
                        println("${YELLOW} _____________________________________________")
                        println()
                        historicoGuardado(nombreFichero, numIncog, intentos)
                        break
                    } else {
                        println("      ${BG_GREEN}${BLACK} $aciertos ${BG_BLACK}${WHITE} Aciertos ${BG_YELLOW}${BLACK} $posibles ${BG_BLACK}${WHITE} Coincidencias ${RESET}")
                        println()
                    }

                    if (jugadas == maxJugadas) {
                        println("${RESET}      ${RED}Lo siento ${RESET}")
                        println("${RESET}      ${RED}NO Adivinaste el número secreto, era:${BG_RED}${BLACK} $numIncog ${RESET}")
                        println("${RESET}      ${RED}Usaste $maxJugadas intentos                                    ${RESET}")
                        println("${YELLOW} _____________________________________________")
                        println()
                        historicoGuardado(nombreFichero, numIncog, intentos)
                    }
                }
            }

            2 -> {
                val juegoAnterior= cargarJuego(nombreFichero)
                if (juegoAnterior != null) {
                    println("${GREEN}      Última jugada guardada:${RESET}")
                    println("${YELLOW}$juegoAnterior${RESET}")
                } else {
                    println("${RED}      No hay registro de una jugada anterior.${RESET}")
                }
            }

            3 -> println("${PURPLE}      Gracias por jugar${RESET}")

            else -> println("${RED}      Opción inválida\n      Por favor elige una opción válida.${RESET}")
        }
    }
}

fun numIncogCreado(): String {
    val rangoNum = (1..6).shuffled().take(4)
    return rangoNum.joinToString("")
}

fun numRepetidos(entrada: String): Boolean {
    return entrada.toSet().size != entrada.length
}

fun evaluarAcierto(acierto: String, numSecret: String): Pair<Int,Int> {
    var tiros = 0
    var rondas = 0

    for (i in acierto.indices) {
        if (acierto[i] == numSecret[i]) {
            tiros++
        } else if (acierto[i] in numSecret) {
            rondas++
        }
    }
    return Pair(tiros, rondas)
}

fun historicoGuardado(archivo: String, numIncog: String, intentos: List<String>) {
    val recorrido = StringBuilder("      Número secreto: $numIncog\n")
    intentos.forEach { recorrido.append("$it\n") }
    File(archivo).writeText(recorrido.toString())
}

fun cargarJuego(fichero: String): String?{
    val archivo = File(fichero)
    return if (archivo.exists()){
                archivo.readText()
            } else {
                null
            }
}