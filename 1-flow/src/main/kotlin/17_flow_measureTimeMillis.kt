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
 * 该函数用于更改流发射的上下文。 以下示例展示了更改流上下文的正确方法，该示例还通过打印相应线程的名字以展示它们的工作方式：
 * @Counter :
 * @Answer :
 */

fun simple16(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100) // 假装我们异步等待了 100 毫秒
        emit(i) // 发射下一个值
    }
}

fun main() = runBlocking<Unit> {
    println("test measureTimeMillis :")
    val time = measureTimeMillis {
        simple16().collect {
            delay(300)
            println(it)
        }
    }
    // 整个收集过程大约需要 1200 毫秒（3 个数字，每个花费 400 毫秒）：
    println("Collected in $time ms")
}