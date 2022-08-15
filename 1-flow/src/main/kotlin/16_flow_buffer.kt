import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 14:48
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :  flowOn
 *  buffer 操作符来并发运行这个 simple 流中发射元素的代码以及收集的代码
 * @Counter :
 * @Answer :
 */
fun simple17(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100) // 假装我们异步等待了 100 毫秒
        emit(i) // 发射下一个值
    }
}

fun main() = runBlocking<Unit> {
    println("test buffer :")
    val time = measureTimeMillis {
        simple17()
            .buffer()// 并发运行
            .collect {
                delay(300)
                println(it)
            }
    }
    // 它产生了相同的数字，只是更快了，由于我们高效地创建了处理流水线，
    // 仅仅需要等待第一个数字产生的 100 毫秒以及处理每个数字各需花费的 300 毫秒
    // 。这种方式大约花费了 1000 毫秒来运行：
    println("Collected in $time ms")
}