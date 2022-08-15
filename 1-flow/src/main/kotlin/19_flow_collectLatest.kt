import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 14:48
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :  collectLatest:处理最新值
 *
 *

 *
 * @Counter :
 * @Answer :
 */

fun simple19(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100) // 假装我们异步等待了 100 毫秒
        emit(i) // 发射下一个值
    }
}

fun main() = runBlocking<Unit> {
    println("test collectLatest :")
    val time = measureTimeMillis {
        simple19()
            .collectLatest { value -> // 取消并重新发射最后一个值
                println("Collecting $value")
                delay(300) // 假装我们花费 300 毫秒来处理它

                println("Done value : $value")

            }

    }

// 由于 collectLatest 的函数体需要花费 300 毫秒，但是新值每 100 秒发射一次，
// 我们看到该代码块对每个值运行，但是只收集最后一个值：
    println("Collected in $time ms")
}