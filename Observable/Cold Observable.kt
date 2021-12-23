package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    val coldObservable = Observable.just(1, 2, 3, 4)
    val observer1 = object : Observer<Int> {

        override fun onSubscribe(d: Disposable) {
            println("observer1 onSubscribe")
        }

        override fun onNext(t: Int) {
            println("observer1 onNext = $t")
        }

        override fun onError(e: Throwable) {
            println("observer1 onError = $e")
        }

        override fun onComplete() {
            println("observer1 onComplete")
        }
    }

    val observer2 = object : Observer<Int> {

        override fun onSubscribe(d: Disposable) {
            println("observer2 onSubscribe")
        }

        override fun onNext(t: Int) {
            println("observer2 onNext = $t")
        }

        override fun onError(e: Throwable) {
            println("observer2 onError = $e")
        }

        override fun onComplete() {
            println("observer2 onComplete")
        }
    }

    // observer1 구독
    coldObservable.subscribe(observer1)
    runBlocking {
        delay(800)
    }
    // 0.8초 후에 observer2 구독
    coldObservable.subscribe(observer2)
}

//observer1 onSubscribe
//observer1 onNext = 1
//observer1 onNext = 2
//observer1 onNext = 3
//observer1 onNext = 4
//observer1 onComplete
//observer2 onSubscribe
//observer2 onNext = 1
//observer2 onNext = 2
//observer2 onNext = 3
//observer2 onNext = 4
//observer2 onComplete