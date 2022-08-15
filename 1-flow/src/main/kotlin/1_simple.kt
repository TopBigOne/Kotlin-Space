/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 13:45
 * @Url :  https://www.kotlincn.net/docs/reference/coroutines/flow.html
 * @Level :  easy  medium hard
 * @Desc : 学习一下kotlin
 * @Counter :
 * @Answer :
 */

fun simple(): List<Int> = listOf(1, 2, 3)
fun main() {

    simple().forEach {
        println("item value : $it")
    }
}
