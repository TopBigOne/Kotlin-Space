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
 * @Desc :  流的操作符
 * @Counter :
 * @Answer :
 */


suspend fun performRequest2(request: Int): String {
    delay(1000) // 模仿长时间运行的异步工作
    return "response $request"
}

fun main() = runBlocking<Unit> {
    (1..3).asFlow() // a flow of requests
        .transform {
            // 成对的发射出去
            emit("Making request $it")
            emit(performRequest2(it))
        }
        .collect { response ->

            println(response)
        }
}