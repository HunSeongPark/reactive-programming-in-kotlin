package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.just(IntData(1), IntData(2))

    // map을 사용한 타입 캐스팅
    observable
        .map {
            it as ParentIntData
        }
        .subscribe {
            println("map - $it")
        }

    // cast를 사용한 타입 캐스팅
    observable
        .cast(ParentIntData::class.java)
        .subscribe {
            println("cast - $it")
        }
}

open class ParentIntData(val value: Int) {
    override fun toString(): String {
        return "ParentIntData($value)"
    }
}
class IntData(value: Int) : ParentIntData(value) {
    override fun toString(): String {
        return "IntData($value)"
    }
}

//map - IntData(1)
//map - IntData(2)
//cast - IntData(1)
//cast - IntData(2)