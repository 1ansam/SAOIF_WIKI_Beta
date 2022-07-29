package com.yxf.saoifwiki.service

import com.yxf.saoifwiki.bean.ImageInfoBean
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path

/**
 *   author:yxf
 *   time:2022/7/29
 */

interface QueryService {
    @GET("/saoif/{path}")
    suspend fun getBeanList(@Path("path")path : String) : List<ImageInfoBean>
}