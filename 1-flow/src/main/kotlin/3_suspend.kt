/**
 * @author :  dev
 * @version :
 * @Date :   2022/7/17 14:06
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :  挂起函数:
 * 计算过程阻塞运行该代码的主线程。 当这些值由异步代码计算时，
 * 我们可以使用 suspend 修饰符标记函数 simple， 这样它就可以在不阻塞的情况下执行其工作并将结果作为列表返回
 * @Counter :
 * @Answer :
 */
import kotlinx.coroutines.*

suspend fun simple3(): List<Int> {
    delay(8000) // 假装我们在这里做了一些异步的事情
    return listOf(1, 2, 3)
}

fun simple4(): List<Int> {
    return listOf(4, 5, 6)
}


fun obtainLabelChildCount(list: List<String>) {
    list.chunked(30).forEach { chunkedList ->
        val tagIds = chunkedList.map {

        }


//        val countResults = dao.getChildrenSize(tagIds)
//        countResults.forEach { result ->
//            list.firstOrNull { it.tagId == result.parentId }?.childCount = result.childCount
//        }
//

    }
}


fun main() = runBlocking {

    val result1 = simple3()
    val result2 = simple4()

    println("result1 :$result1")
    println("result2 :$result2")

}
