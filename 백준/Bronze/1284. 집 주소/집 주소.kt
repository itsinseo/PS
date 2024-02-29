import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val n = readLine()
        if (n.equals("0")) {
            break
        }
        var length = 1;
        for (ch: Char in n) {
            length += when (ch) {
                '1' -> 3
                '0' -> 5
                else -> 4
            }
        }
        bufferedWriter.write(length.toString())
        bufferedWriter.write("\n")
    }

    bufferedWriter.flush()
}