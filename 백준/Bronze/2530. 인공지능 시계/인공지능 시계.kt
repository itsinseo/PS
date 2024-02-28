import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a, b, c) = readLine().split(' ').map { it.toInt() }
    val d = readLine().toInt()

    var totalSeconds = a * 60 * 60 + b * 60 + c + d
    totalSeconds %= (24 * 60 * 60)

    val hours = totalSeconds / (60 * 60)
    val minutes = totalSeconds % (60 * 60) / 60
    val seconds = totalSeconds % (60 * 60) % 60

    println("$hours $minutes $seconds")
}