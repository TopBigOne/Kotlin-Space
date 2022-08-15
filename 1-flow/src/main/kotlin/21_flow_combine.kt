import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 14:48
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :  combine:每次从 flowA 发出新的 item ，会将其与 flowB 的最新的 item 合并。
 *
 * @Counter :
 * @Answer :
 */


fun testBy_zip() = runBlocking<Unit> {
    println("use: zip")
    // 发射数字 1..3，间隔 300 毫秒
    val nums = (1..3).asFlow().onEach { delay(300) }

    // 每 400 毫秒发射一次字符串
    val strs = flowOf("one", "two", "three").onEach { delay(400) }

    // 记录开始的时间
    val startTime = System.currentTimeMillis()
    nums.zip(strs) { a, b -> "$a -> $b" } // 使用“zip”组合单个字符串
        .collect { value -> // 收集并打印
            println("$value , at ${System.currentTimeMillis() - startTime} ms from start")
        }
}

fun testBy_combine() = runBlocking<Unit> {
    println("use: combine")
    val nums = (1..3).asFlow().onEach { delay(300) } // 发射数字 1..3，间隔 300 毫秒
    // 每 600 毫秒发射一次字符串
    val strs = flowOf("one", "two", "three","four").onEach { delay(600) }

    // 记录开始的时间
    val startTime = System.currentTimeMillis()

    nums.combine(strs) { a, b -> "$a -> $b" } // 使用“combine”组合单个字符串
        .collect { value -> // 收集并打印
            println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }

}


fun main() = runBlocking<Unit> {
    testBy_zip()
    println("-----------------")
    testBy_combine()
}