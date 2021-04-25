package codejam2021.round1b

fun main() {
    val inputFileName = "src/codejam2021/round1b/BrokenClock.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    // TODO test set 2 & 3
    for (case in 1..readLine()!!.toInt()) {
        val (a, b, c) = readLine()!!.split(' ').map { it.toLong() }

        listOfNotNull(
            findClock(a, b, c),
            findClock(a, c, b),
            findClock(b, a, c),
            findClock(b, c, a),
            findClock(c, a, b),
            findClock(c, b, a),
        ).first().let {
            println("Case #$case: ${it / HOUR} ${it / MINUTE % 60} ${it / SECOND % 60} ${it % SECOND}")
        }
    }
}

private const val SECOND = 1000000000L
private const val MINUTE = 60 * SECOND
private const val HOUR = 60 * MINUTE
private const val MAX = 12 * HOUR

private fun findClock(h: Long, m: Long, s: Long): Long? {
    for (i in 0 until 43200) {
        val hr = (h + i * SECOND) % MAX
        val mr = (m + i * SECOND) % MAX
        val sr = (s + i * SECOND) % MAX
        if (hr * 12 % MAX == mr && mr * 60 % MAX == sr) return hr
    }

    return null
}
