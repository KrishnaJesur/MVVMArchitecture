package com.krishna.kotlinlist.base

interface BaseNetworkCallBack {
    fun onLogout()
    fun onUpdateApp(mandatory: Boolean)
    fun onMaintenance()
    fun onUnauthorised()

}
