import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 14:48
 * @Url : 解释：https://blog.csdn.net/SLFq6OF5O7aH/article/details/106345500
 * @Level :  easy  medium hard
 * @Desc :  atMapConcat 由 map、flattenConcat 操作符实现。
 *
 * @Counter :
 * @Answer :
 */

fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First")
    // 等待 500 毫秒
    delay(500)
    emit("$i: Second")
}


fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    (1..3).asFlow().onEach {
        // 走3次，每次间隔100ms
        delay(100)
    }.flatMapConcat {
        requestFlow(it)
    }.collect {
        println("$it at ${System.currentTimeMillis() - startTime} ms from start")
    }

}