package day01
import common.*
import java.nio.file.Paths
import kotlin.text.*

class Part1
{
    init{
        val data = DataReader.readDataAsIntegers("/day1.data")
//        val report = ExpenseReport(data)

        val result = FindItemsThatSumsTo2020Algorithm().process(data)

        println(result.left.value * result.right.value)

// stwórz raport
        // odpal algorytm
        // podaj wynik
    }



}