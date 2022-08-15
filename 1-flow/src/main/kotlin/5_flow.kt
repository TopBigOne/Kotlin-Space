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


fun simple7(): Flow<Int> = flow { // 流构建器
    for (i in 1..3) {
        delay(100)
        // 发送下一个值
        emit(i)
    }
}

fun main() = runBlocking {
    println("Calling simple function...")
    val flow = simple7()
    println("Calling collect...")
    flow.collect { value ->
        println(value)
    }
    println("Calling collect again...")
    flow.collect { value ->
        println(value)
    }
    println("Calling collect again and again...")
    flow.collect { value ->
        println(value)
    }

}