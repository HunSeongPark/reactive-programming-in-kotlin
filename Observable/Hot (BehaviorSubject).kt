package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable = Observable.interval(200, TimeUnit.MILLISECONDS)

    val behaviorSubject = BehaviorSubject.create<Long>()

    val observer1 = object : Observer<Long> {
        override fun onSubscribe(d: Disposable) {
            println("observer 1 - onSubscribe")
        }

        override fun onNext(t: Long) {
            println("observer 1 - onNext = $t")
        }

        override fun onError(e: Throwable) {
            println("observer 1 - onError = $e")
        }

        override fun onComplete() {
            println("observer 1 - onComplete")
        }

    }

    val observer2 = object : Observer<Long> {
        override fun onSubscribe(d: Disposable) {
            println("observer 2 - onSubscribe")
        }

        override fun onNext(t: Long) {
            println("observer 2 - onNext = $t")
        }

        override fun onError(e: Throwable) {
            println("observer 2 - onError = $e")
        }

        override fun onComplete() {
            println("observer 2 - onComplete")
        }

    }

    // BehaviorSubject가 observable를 구독
    observable.subscribe(behaviorSubject)

    // observe1이 BehaviorSubject를 구독
    behaviorSubject.subscribe(observer1)

    // 0.4초 후 observer2가 BehaviorSubject를 구독
    runBlocking {
        delay(400)
        behaviorSubject.subscribe(observer2)
        delay(400)
    }
}

//observer 1 - onSubscribe
//observer 1 - onNext = 0
//observer 1 - onNext = 1
//observer 2 - onSubscribe
//observer 2 - onNext = 1
//observer 1 - onNext = 2
//observer 2 - onNext = 2
//observer 1 - onNext = 3
//observer 2 - onNext = 3