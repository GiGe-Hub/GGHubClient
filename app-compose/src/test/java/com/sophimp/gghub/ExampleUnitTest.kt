package com.sophimp.gghub

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Assert.*
import java.lang.Thread.sleep
import java.util.concurrent.FutureTask

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun coroutineTest() {
        CoroutineScope(Dispatchers.IO).launch {
            val job = async {
                for (i in 1 until 10) {
                    val childJob = async {
                        val futureTask = FutureTask {
                            sleep(500)
                            println("async job ${Thread.currentThread()} ~~~ $i")
                        }
                        Thread(futureTask).start()
                        try {
                            futureTask.get()
                        } catch (e : Exception) {
                            e.printStackTrace()
                        }
                    }
                    childJob.join()
                }
            }
            job.join()
            println("after await tasks")
        }
    }

}