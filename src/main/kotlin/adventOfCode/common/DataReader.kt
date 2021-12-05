package adventOfCode.common

import adventOfCode.domain.Lines
import java.io.File

class DataReader {
    companion object {
        fun readDataAsIntegers(fileName: String): List<Int> = readData(fileName).map { it.toInt() }


        fun readData(year: Int, day: Int): List<String>{
            val fileName = "/year$year/day$day.data"
            return readData(fileName)
        }

        fun readRawData(year: Int, day: Int): String{
            val fileName = "/year$year/day$day.data"
            return readRawData(fileName)
        }

        fun readData(fileName: String): List<String> {
            val fixedFileName = if (fileName.startsWith("/")) fileName  else "/$fileName"
            val absoluteFileName = object {}.javaClass.getResource(fixedFileName).file
            return File(absoluteFileName).useLines { it.toList() }
        }

        fun readRawData(fileName: String): String {
            val fixedFileName = if (fileName.startsWith("/")) fileName  else "/$fileName"
            val absoluteFileName = object {}.javaClass.getResource(fixedFileName).file
            return File(absoluteFileName).readText()
        }
    }
}

fun readInput(year: Int, day: Int): Lines = DataReader.readData(year, day)
fun readRawInput(year: Int, day: Int): String = DataReader.readRawData(year, day)
