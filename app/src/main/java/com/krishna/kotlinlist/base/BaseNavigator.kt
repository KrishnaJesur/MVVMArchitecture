package com.krishna.kotlinlist.base

interface BaseNavigator {
    fun onLogout()
    fun onUpdateApp(mandatory: Boolean)
    fun onMaintenance()
    fun onUnauthorised()

}