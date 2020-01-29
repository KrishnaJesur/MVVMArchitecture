package com.krishna.kotlinlist.activity.activityroutelist

interface RouteListNavigator {

    fun onRouteListFetched(children: GetRouteListModel)
    fun onRouteFetchFailed(error: String)

}