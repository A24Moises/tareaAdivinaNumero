import kotlin.random.Random
import java.io.File
//----------------------------------------------------------------------------------------------------
fun main() {
    val maxAttempts = 10
    val fileName = "last_game_trace.txt"
    val secretNumber = generateSecretNumber()
    var attempts = mutableListOf<String>()
    var option: Int

    do {
        println("* * * * * \n * * * *\n  * * *\n   * *\n    *")
        println("\u001B[32m\n1. Jugar\n2. Ver traza de último intento\n3. Salir\u001B[0m")
        println("_________________________")
        print("\u001B[32mOpción Seleccionada: ")
        option = readLine()?.toIntOrNull() ?: 0

        when (option) {
            1 -> {
                attempts = mutableListOf()
                println("\u001B[36mIniciando un nuevo juego. Debes adivinar un número de 4 dígitos sin cifras repetidas del 1 al 6.\u001B[0m")
                println("____________________________________________________________________________________________________________________")

                for (attempt in 1..maxAttempts) {
                    print("\u001B[36m\nIntento $attempt: Teclea un número de 4 cifras sin números repetidos:\u001B[0m ")
                    val guess = readLine()?.trim()

                    if (guess == null || guess.length != 4 || !guess.matches(Regex("[1-6]{4}")) || hasDuplicates(guess)) {
                        println("\u001B[31mNúmero inválido. Intenta de nuevo.\u001B[0m")
                        continue
                    }

                    val (hits, matches) = evaluateGuess(guess, secretNumber)
                    attempts.add("Intento $attempt: $guess, Aciertos: $hits, Coincidencias: $matches")

                    if (hits == 4) {
                        println("\u001B[32m¡Felicidades! Has adivinado el número secreto: $secretNumber en $attempt intentos.\u001B[0m")
                        saveTrace(fileName, secretNumber, attempts)
                        break
                    } else {
                        println("\u001B[33m\u001B[42m $hits \u001B[0m Aciertos, \u001B[43m $matches \u001B[0m Coincidencias\u001B[0m")
                    }

                    if (attempt == maxAttempts) {
                        println("\u001B[31mLo siento, no adivinaste el número secreto $secretNumber en $maxAttempts intentos\u001B[0m")
                        saveTrace(fileName, secretNumber, attempts)
                    }
                }
            }

            2 -> {
                val previousGame = loadPreviousGame(fileName)
                if (previousGame != null) {
                    println("\u001B[33m\nÚltima jugada guardada:\n$previousGame\u001B[0m")
                } else {
                    println("\u001B[31mNo hay registro de una jugada anterior.\u001B[0m")
                }
            }

            3 -> println("\u001B[36mGracias por jugar\u001B[0m")

            else -> println("\u001B[31mOpción inválida, por favor elige una opción válida.\u001B[0m")
        }
    } while (option != 3)
}
//----------------------------------------------------------------------------------------------------
fun generateSecretNumber(): String {
    val digits = (1..6).shuffled().take(4)
    return digits.joinToString("")
}
//----------------------------------------------------------------------------------------------------
fun hasDuplicates(input: String): Boolean {
    return input.toSet().size != input.length
}
//----------------------------------------------------------------------------------------------------
fun evaluateGuess(guess: String, secret: String): Pair<Int, Int> {
    var hits = 0
    var matches = 0

    for (i in guess.indices) {
        if (guess[i] == secret[i]) {
            hits++
        } else if (guess[i] in secret) {
            matches++
        }
    }
    return Pair(hits, matches)
}
//----------------------------------------------------------------------------------------------------
fun saveTrace(fileName: String, secretNumber: String, attempts: List<String>) {
    val trace = StringBuilder("Número secreto: $secretNumber\n")
    attempts.forEach { trace.append("$it\n") }
    File(fileName).writeText(trace.toString())
}
//----------------------------------------------------------------------------------------------------
fun loadPreviousGame(fileName: String): String? {
    val file = File(fileName)
    return if (file.exists()) file.readText() else null
}
//----------------------------------------------------------------------------------------------------
*/
import kotlin.random.Random
import java.io.File
//Colores_-------------------------------------------------
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
    val nombreFichero = "Ultimo_Historico_Juego.txt"
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
