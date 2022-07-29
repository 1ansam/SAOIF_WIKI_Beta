package com.yxf.saoifwiki.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yxf.saoifwiki.RetrofitService
import com.yxf.saoifwiki.bean.ImageInfoBean
import com.yxf.saoifwiki.service.QueryService
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *   author:yxf
 *   time:2022/7/29
 */
class SAOIFRepo {
    val retrofit = RetrofitService.create(QueryService::class.java)

    suspend fun getBeanList() = retrofit.getBeanList("")
//    fun getBeanList() : LiveData<List<ImageInfoBean>>{
//        val liveData = MutableLiveData<List<ImageInfoBean>>()
//        retrofit.getBeanList("").enqueue(object : Callback<List<ImageInfoBean>>{
//            override fun onResponse(
//                call: Call<List<ImageInfoBean>>,
//                response: Response<List<ImageInfoBean>>
//            ) {
//
//                liveData.value = response.body()
//                Log.e("TAG", "onResponse: ${response.body()}", )
//            }
//
//            override fun onFailure(call: Call<List<ImageInfoBean>>, t: Throwable) {
//                Log.e("TAG", "onFailure: ${t.message}", )
//            }
//        })
//        return liveData
//    }

}