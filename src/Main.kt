object StockList {
    fun stockSummary(lstOfArt: Array<String>, lstOfCat: Array<String>): String {
        if (lstOfArt.isEmpty() || lstOfCat.isEmpty() )
            return ""

        val builder = StringBuilder()

        lstOfCat.forEach { cat ->
            run {
                val filtered = lstOfArt.filter { art -> art.startsWith(cat) }
                var count = 0

                filtered.forEach { filter ->
                    run {
                        val bookCount = filter.split(" ")[1].toInt()
                        count += bookCount
                    }
                }

                builder.append("($cat : $count) - ")
            }
        }

        return builder.toString().substring(0, builder.length - 3)
    }
}

fun main() {
    var b = arrayOf("BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600")
    var c = arrayOf("A", "B", "C", "D")

    println(StockList.stockSummary(b, c))
}