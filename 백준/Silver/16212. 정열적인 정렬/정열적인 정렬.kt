import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    val arr = readLine().split(' ').map { it.toInt() }.sorted()

    println(arr.joinToString(" "))
}