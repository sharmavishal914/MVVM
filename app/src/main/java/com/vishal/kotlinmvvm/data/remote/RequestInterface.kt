package com.vishal.kotlinmvvm.data.remote

import com.vishal.kotlinmvvm.data.model.Model
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by Administrator on 1/15/2018.
 */
interface RequestInterface {
    @GET("?service=ip")
    fun getServiceIP(): Observable<Model>

    // https://mobilewash-1147.firebaseio.com/.json
    @GET
    fun getMW(@Url string: String): Observable<Model>

}