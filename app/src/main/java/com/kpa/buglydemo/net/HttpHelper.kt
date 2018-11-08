package com.kpa.buglydemo.net

import com.kpa.buglydemo.config.URLConfig
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *author: mr.kong
 *Date:2018/10/31
 *description:
 *project name:BuglyDemo
 **/
object HttpHelper {
    private const val DEFAULT_TIME_OUT = 5L//超时时间 5s
    private const val DEFAULT_READ_TIME_OUT = 10L
    private lateinit var mRetrofit: Retrofit
    private val cookieStore: HashMap<String, MutableList<Cookie>> = HashMap()

    init {
        val builder = OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .cookieJar(object : CookieJar {
                    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
                        cookieStore[url.host()] = cookies
                    }

                    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
                        return cookieStore[url.host()] ?: ArrayList<Cookie>()
                    }
                })

        mRetrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .baseUrl(URLConfig.BASE_URL)
                .build()
    }

    fun <T> create(clazz: Class<T>): T {
        return mRetrofit.create(clazz)
    }

}