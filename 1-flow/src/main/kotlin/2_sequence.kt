/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 13:51
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
private fun simple2(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(1000) // pretend we are computing it
        yield(i) // yield next value
    }
}

fun main() {
    simple2().forEach { i ->
        println(i)
    }

}