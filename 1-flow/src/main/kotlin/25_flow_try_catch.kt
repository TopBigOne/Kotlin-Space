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
fun simple25(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting ----> $i")
        emit(i) // 发射下一个值
    }
}

fun simple25_2(): Flow<String> = flow {
    for (item in 1..3) {
        emit(item)
    }
}.map { value ->
    check(value <= 1) {
        "Crashed on $value"
    }
    // 最后一行值返回..
    "string $value"
}

fun simple25_3(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}

fun simple25_4(): Flow<Int> = (1..3).asFlow()


private suspend fun testOne() {
    try {
        println("收集器 try 与 catch")
        simple25().collect { value ->
            println("curr value : $value")
            check(value <= 1) {
                "Collected $value"
            }
        }
    } catch (e: Throwable) {
        println("Caught  $e")
    }
}

suspend fun testTwo() {
    println("一切都已捕获")
    try {
        simple25_2().collect {
            println(it)
        }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}


suspend fun testThree() {
    println("异常透明性")
    simple25_2()
        .catch {
            // 发射一个异常
                e ->
            emit("Caught $e")
        }
        .collect {
            println(it)
        }
}

suspend fun testFour() {
    println("声明式捕获")
    simple25_3()
        .onEach {
            check(it <= 1) { "Collected $it" }
            println(it)
        }.catch { e ->
            print("Caught $e")
        }.collect()
}


suspend fun testFive() {
    println("命令式 finally 块")
    try {
        simple25_4().collect { value -> println(value) }
    } finally {
        println("Done")
    }
}


fun main() = runBlocking<Unit> {
    testOne()
    testTwo()
    testThree()
    testFour()
}

