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
fun foo(): Flow<Int> = flow {
    for (i in 1..5) {
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    foo().collect { value ->
        if (value == 3){
            cancel()
        }
        println(value)
    }
}
