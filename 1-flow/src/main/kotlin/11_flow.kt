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
 * @Desc :  流的每次单独收集都是按顺序执行的，除非进行特殊操作的操作符使用多个流
 *
 * @Counter :
 * @Answer :
 */


fun main() = runBlocking {
    (1..5)
        .asFlow()// a flow of requests
        .filter {
            it % 2 == 0
        }
        .map {
            println("map $it")
        }
        .collect { it ->

            println("collect $it")
        }
}