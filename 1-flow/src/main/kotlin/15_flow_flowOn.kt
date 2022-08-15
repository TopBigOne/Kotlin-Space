import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

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

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
fun simple15(): Flow<Int> = flow {
    for (item in 1..3) {
        // 假装我们以消耗 CPU 的方式进行计算
        Thread.sleep(100)
        emit(item)
    }
}.flowOn(Dispatchers.Default)


fun main() = runBlocking<Unit> {
    println("test flowOn : ")
    simple15().collect {
        log("it $it")
    }
}