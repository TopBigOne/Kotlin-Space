import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 14:48
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :  流的取消
 * @Counter :
 * @Answer :
 */


fun simple8(): Flow<Int> = flow { // 流构建器
    for (i in 1..3) {
        delay(100)
        // 发送下一个值
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    withTimeoutOrNull(250) {
        simple8().collect {
            println("item : $it")
        }
        println("Done")
    }

}