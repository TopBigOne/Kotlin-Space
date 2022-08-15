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
 * @Desc :  限长过渡操作符
 * @Counter :
 * @Answer :
 */


fun numbers2(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)

    } finally {
        println("Finally in numbers")
    }
}


fun main() = runBlocking<Unit> {
    numbers2() // a flow of requests
        .take(2)// 只获取前2个
        .collect { response ->

            println(response)
        }
}