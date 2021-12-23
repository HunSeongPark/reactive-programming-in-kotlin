package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observer = object : Observer<Any> {

        lateinit var disposable: Disposable

        override fun onSubscribe(d: Disposable) {
            println("onSubscribe")
            disposable = d
        }

        override fun onNext(t: Any) {
            println("onNext = $t")
            if (t as Long >= 10 && !disposable.isDisposed) {
                disposable.dispose()
                println("Dispose!")
            }
        }

        override fun onError(e: Throwable) {
            println("onError = $e")
        }

        override fun onComplete() {
            println("onComplete")
        }

    }

    // range(start, end) : start 부터 end까지의 수를 발행한다.
    val rangeObservable = Observable.range(0, 3)
    rangeObservable.subscribe(observer)

    // empty() : onNext 없이 (아이템을 발행하지 않고) 즉시 onComplete를 발생시킨다.
    val emptyObservable = Observable.empty<Any>()
    emptyObservable.subscribe(observer)


    runBlocking {
        // interval(period, unit) : 구독취소, 프로그램 종료 전까지 period 간격 마다 0부터 숫자를 발행한다.
        val intervalObservable = Observable.interval(200, TimeUnit.MILLISECONDS)
        intervalObservable.subscribe(observer)
        delay(10000)
    }

    runBlocking {
        // timer(period, unit) : period 간격 뒤에 딱 한 번 발행한다.
        val timerObservable = Observable.timer(200, TimeUnit.MILLISECONDS)
        timerObservable.subscribe(observer)
        delay(600)
    }


}