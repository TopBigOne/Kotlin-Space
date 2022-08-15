import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 14:48
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :  末端操作符：
 * @Counter :
 * @Answer :
 */


fun main() = runBlocking<Unit> {
    println("test reduce : ")
    val sum = (1..5).asFlow()
        .map { it * it }
        .reduce { a, b ->
            a + b
        }
    println("sum : $sum")
}