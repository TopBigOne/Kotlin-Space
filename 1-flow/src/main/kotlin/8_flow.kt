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

/**
 *TMD ,就是调用asFlow()
 *
 */

suspend fun performRequest(request: Int): String {
    delay(1000)
    return "response $request"

}


fun main() = runBlocking<Unit> {
    (1..3).asFlow() // a flow of requests
        .map {
            performRequest(it)
        }
        .collect { response ->
            println(response)
        }
}