package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.just(2,1,4,3)
    val strObservable = Observable.just("Banana", "Car", "Apple")
    val myItemObservable = Observable.just(MyItem(3), MyItem(5), MyItem(1))

    // Int type 아이템에 대한 정렬
    observable
        .sorted()
        .subscribe {
            println("sorted(Int) - $it")
        }

    // String type 아이템에 대한 정렬
    strObservable
        .sorted()
        .subscribe {
            println("sorted(String) - $it")
        }

    // data class에 대한 custom 정렬
    myItemObservable
        .sorted { item1, item2 ->
            item1.value - item2.value
        }
        .subscribe {
            println("sorted(Custom) - $it")
        }
}

data class MyItem(val value: Int)

//sorted(Int) - 1
//sorted(Int) - 2
//sorted(Int) - 3
//sorted(Int) - 4
//sorted(String) - Apple
//sorted(String) - Banana
//sorted(String) - Car
//sorted(Custom) - MyItem(value=1)
//sorted(Custom) - MyItem(value=3)
//sorted(Custom) - MyItem(value=5)