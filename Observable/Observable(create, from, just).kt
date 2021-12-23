package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.io.IOException
import java.util.concurrent.TimeUnit

fun main() {
    val observer =  object : Observer<Any> {

        // 해당 observer가 observable을 구독할 때 호출
        override fun onSubscribe(d: Disposable) {
            println("onSubscribe")
        }

        // observable에서 새로운 아이템이 발행될 때 호출
        override fun onNext(t: Any) {
            println("onNext = $t")
        }

        // observable에서 error가 발생했을 때 호출되고 observable 종료
        override fun onError(e: Throwable) {
            println("onError = $e")
        }

        // observable의 아이템 발행이 모두 완료될 때 호출되고 observable 종료
        override fun onComplete() {
            println("onComplete")
        }

    }

    // RxKotlin을 통해 List를 Observable로 변환
    val observable = listOf(0,1,2,3,4).toObservable()

    // create
    val observable2 = Observable.create<Int> {
        it.onNext(0)
        it.onNext(1)
        it.onNext(2)
        it.onNext(3)
        it.onNext(4)
        it.onError(IOException())
    }

    val array = arrayOf(1,2,3) // Array
    val list = listOf(4,5,6) // List (Iterable)


    val observableFromArray = Observable.fromArray(array) // fromArray
    val observableToObservable1 = array.toObservable() // toObservable

    val observableFromIterable = Observable.fromIterable(list) // fromIterable
    val observableToObservable2 = list.toObservable() // toObservable

    // just
    val observable3 = Observable.just(1,2,3)
    val observable4 = Observable.just(listOf(0,1), listOf(2,3), listOf(4,5))

    //subscribe 메소드를 통해 해당 observer가 observable 구독
    observable.subscribe(observer)
}
}