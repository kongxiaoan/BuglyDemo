package com.kpa.buglydemo.net

import com.kpa.buglydemo.entry.BeautyEntry
import com.kpa.buglydemo.entry.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable
import rx.functions.Func1

/**
 *author: mr.kong
 *Date:2018/10/31
 *description:
 *project name:BuglyDemo
 **/
object BeautyLoader : ObjectLoader() {
    fun getBeautyData(name: String, count: Int, page: Int): Observable<MutableList<Result>>? {
        return observe(HttpHelper.create(BeautyInterface::class.java) .getBeautyData(name, count, page))
                .map(object : Func1<BeautyEntry, MutableList<Result>> {
                    override fun call(t: BeautyEntry?): MutableList<Result> {
                        return t?.results as MutableList<Result>
                    }
                })
    }

    interface BeautyInterface {
        @GET("api/data/{name}/{count}/{page}")
        fun getBeautyData(@Path("name") name: String
                          , @Path("count") count: Int, @Path("page") page: Int): Observable<BeautyEntry>
    }
}