import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
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
 * @Desc :  流构建器
 * @Counter :
 * @Answer :
 */

/**
 *TMD ,就是调用asFlow()
 *
 */
fun main() = runBlocking<Unit> {
    (1..6).asFlow().collect {
        println("value: $it")
    }
}