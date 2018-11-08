package com.kpa.buglydemo.net

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 *author: mr.kong
 *Date:2018/10/31
 *description:
 *project name:BuglyDemo
 **/
open class ObjectLoader {
    protected fun <T> observe(observable: Observable<T>): Observable<T> {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
    }
}