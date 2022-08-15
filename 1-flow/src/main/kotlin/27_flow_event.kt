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
fun events(): Flow<Int> = (1..3).asFlow().onEach { delay(100) }

fun main() = runBlocking<Unit> {
    events()
        .onEach { event ->
            println("Event: $event")
        }.collect()
    println("Done")
}
