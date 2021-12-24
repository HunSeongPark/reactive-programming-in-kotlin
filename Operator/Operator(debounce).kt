package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable = Observable.create<String> {
        it.onNext("H")
        runBlocking { delay(100) }
        it.onNext("He")
        runBlocking { delay(100) }
        it.onNext("Hel")
        runBlocking { delay(100) }
        it.onNext("Hell")
        runBlocking { delay(100) }
        it.onNext("Hello")
        runBlocking { delay(300) }
        it.onComplete()
    }

    observable
        .debounce(200, TimeUnit.MILLISECONDS)
        .subscribe {
            println("Search Query = \"$it\"")
        }
}

// Search Query = "Hello"