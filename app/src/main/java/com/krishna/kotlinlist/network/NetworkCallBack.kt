package com.krishna.kotlinlist.network

import com.krishna.kotlinlist.base.BaseNetworkCallBack

interface NetworkCallBack : BaseNetworkCallBack {
    fun onSuccess(response: Any?)
    fun onError(errorBody: String)
}