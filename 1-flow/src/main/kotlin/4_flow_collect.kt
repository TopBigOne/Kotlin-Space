import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 14:48
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */


fun simple6(): Flow<Int> = flow { // 流构建器
    for (i in 1..3) {
        delay(100)
        // 发送下一个值
        emit(i)
    }
}

fun main() = runBlocking {
    // 启动并发线程以验证主线程 没有阻塞
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }

    // 收集这个流
    simple6().collect {
        println("collect : $it")
    }

}