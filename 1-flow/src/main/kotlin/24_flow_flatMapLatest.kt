import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 14:48
 * @Url : 解释：https://blog.csdn.net/SLFq6OF5O7aH/article/details/106345500
 * @Level :  easy  medium hard
 * @Desc :  另一种展平模式是并发收集所有传入的流，并将它们的值合并到一个单独的流，以便尽快的发射值。
 * 它由 flatMapMerge 与 flattenMerge 操作符实现。
 *
 * @Counter :
 * @Answer :
 */

fun requestFlow24(i: Int): Flow<String> = flow {
    emit("$i: First")
    // 等待 500 毫秒
    delay(300)
    emit("$i: Second")
}


fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis() // 记录开始时间
    (1..3).asFlow()
        .onEach { delay(100) } // 每 100 毫秒发射一个数字
        .flatMapLatest {
            requestFlow(it)
        }
        .collect { value -> // 收集并打印
            println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }

}