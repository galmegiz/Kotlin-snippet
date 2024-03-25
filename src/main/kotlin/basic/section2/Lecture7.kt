package basic.section2

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.NumberFormatException


/**
 * 코틀린 예외처리에 대해 다룬다
 * checked exception과  unchecked exception을 구분하지 않는다
 */
fun main() {

}

class Lecture7 {
}

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}

fun parseIntOrThrow2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

// IOE exception을 처리하지 않아도 된다

class FilePrinter{
    fun readFile() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }

    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use{
            reader -> println(reader.readLine())
        }
    }
}