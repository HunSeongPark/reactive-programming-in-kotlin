package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    // Observable.publish()를 통해 connectableObservable 생성
    val connectableObservable = Observable.interval(100L, TimeUnit.MILLISECONDS).publish()

    val observer1 = object : Observer<Long> {

        override fun onSubscribe(d: Disposable) {
            println("observer1 onSubscribe")
        }

        override fun onNext(t: Long) {
            println("observer1 onNext = $t")
        }

        override fun onError(e: Throwable) {
            println("observer1 onError = $e")
        }

        override fun onComplete() {
            println("observer1 onComplete")
        }
    }

    val observer2 = object : Observer<Long> {

        override fun onSubscribe(d: Disposable) {
            println("observer2 onSubscribe")
        }

        override fun onNext(t: Long) {
            println("observer2 onNext = $t")
        }

        override fun onError(e: Throwable) {
            println("observer2 onError = $e")
        }

        override fun onComplete() {
            println("observer2 onComplete")
        }
    }

    // subscribe 수행했으나 connect 전까지는 데이터 발행이 지연됨
    connectableObservable.subscribe(observer1)
    // 현 시점부터 데이터 발행
    connectableObservable.connect()
    runBlocking {
        delay(200)
    }
    // observer2는 connect 이후 0.2초 간 발행된 0, 1에 대한 아이템은 발행받지 못함
    connectableObservable.subscribe(observer2)
    runBlocking {
        delay(200)
    }
}

//observer1 onSubscribe
//observer1 onNext = 0
//observer1 onNext = 1
//observer2 onSubscribe
//observer1 onNext = 2
//observer2 onNext = 2
//observer1 onNext = 3
//observer2 onNext = 3