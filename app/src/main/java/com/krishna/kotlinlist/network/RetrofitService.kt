package com.krishna.kotlinlist.network

import com.krishna.kotlinlist.activity.activityroutelist.GetRouteListModel
import com.krishna.kotlinlist.activity.activityroutelist.GetRouteListReqModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface RetrofitService {

    @POST("GetRoute")
    fun GetRoute(@Body getroutelistreqmodel: GetRouteListReqModel): Deferred<Response<GetRouteListModel>>

}