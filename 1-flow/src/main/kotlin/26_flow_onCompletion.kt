import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 14:48
 * @Url : 解释：https://blog.csdn.net/SLFq6OF5O7aH/article/details/106345500
 * @Desc :  当运算符中的发射器或代码抛出异常时，流收集可以带有异常的完成。 有几种处理异常的方法
 * @Counter :
 * @Answer :
 */
fun simple_26(): Flow<Int> = (1..3).asFlow()
fun simple_26_2(): Flow<Int> = flow {
    emit(1)
    throw RuntimeException()
}

fun main() = runBlocking<Unit> {
    test_1()
    test_2()
}

suspend fun test_1() {
    simple_26()
        .onStart {
            println("onStart")
        }
        .onCompletion {
            println("onCompletion")
        }
        .collect { value -> println(value) }
}


suspend fun test_2() {
    simple_26_2()
        .onStart {
            println("onStart")
        }
        .onCompletion { cause ->
            if (cause != null) {
                println("Flow completed exceptionally")
            }

        }
        .catch { cause ->
            println("Caught exception")
        }
        .collect { value -> println(value) }
}

