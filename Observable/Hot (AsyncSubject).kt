package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.AsyncSubject
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    val observable = Observable.just(1, 2, 3, 4, 5, 6, 7)

    val asyncSubject = AsyncSubject.create<Int>()

    val observer1 = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            println("observer 1 - onSubscribe")
        }

        override fun onNext(t: Int) {
            println("observer 1 - onNext = $t")
        }

        override fun onError(e: Throwable) {
            println("observer 1 - onError = $e")
        }

        override fun onComplete() {
            println("observer 1 - onComplete")
        }

    }

    val observer2 = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            println("observer 2 - onSubscribe")
        }

        override fun onNext(t: Int) {
            println("observer 2 - onNext = $t")
        }

        override fun onError(e: Throwable) {
            println("observer 2 - onError = $e")
        }

        override fun onComplete() {
            println("observer 2 - onComplete")
        }

    }

    // AsyncSubject가 observable를 구독
    observable.subscribe(asyncSubject)

    // observe1이 AsyncSubject를 구독
    asyncSubject.subscribe(observer1)

    // 0.4초 후 observer2가 AsyncSubject를 구독
    runBlocking {
        delay(400)
        asyncSubject.subscribe(observer2)
    }
}

//observer 1 - onSubscribe
//observer 1 - onNext = 7
//observer 1 - onComplete
//observer 2 - onSubscribe
//observer 2 - onNext = 7
//observer 2 - onComplete