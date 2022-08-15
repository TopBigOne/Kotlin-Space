import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 14:48
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :   withContext发出错误：
 * @Counter :
 * @Answer :
 */

fun simple13(): Flow<Int> = flow {
    withContext(Dispatchers.Default) {
        for (item in 1..3) {
            // 假装我们以消耗 CPU 的方式进行计算
            Thread.sleep(1000)
            emit(item)
        }
    }
}


fun main() = runBlocking<Unit> {
    println("test withContext : ")
    simple13().collect {
        println("it $it")
    }
}