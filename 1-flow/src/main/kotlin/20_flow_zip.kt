import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 14:48
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :  zip:
 * zip 操作符会把 flowA 中的一个 item 和 flowB 中对应的一个 item 进行合并。即使 flowB 中的每一个 item 都使用了 delay() 函数，在合并过程中也会等待 delay() 执行完后再进行合并。
 * @Counter :
 * @Answer :
 */


fun main() = runBlocking<Unit> {
    println("test zip :")
    val nums = (1..3).asFlow() // 数字 1..3
    val strs = flowOf("one", "two", "three") // 字符串

    nums.zip(strs) {
        // 组合单个字符串
            a, b ->
        "$a -> $b"
    }.collect {
        // 收集并打印
        println(it)
    }
}