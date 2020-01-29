package com.krishna.kotlinlist.activity.activityroutelist

import android.content.Context
import android.util.Log
import androidx.databinding.ObservableBoolean
import com.krishna.kotlinlist.base.BaseViewModel
import com.krishna.kotlinlist.network.ApiProvider
import com.krishna.kotlinlist.network.ApiRequest
import com.krishna.kotlinlist.network.NetworkCallBack
import com.krishna.kotlinlist.util.Connectivity
import com.krishna.kotlinlist.util.ProjectStrings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RouteListViewModel(
    private var routeListNavigator: RouteListNavigator,
    context: Context
) : BaseViewModel<RouteListNavigator>(routeListNavigator, context),
    NetworkCallBack {


    lateinit var model: GetRouteListReqModel
    var isRoutelistFetched: ObservableBoolean = ObservableBoolean(false)

    override fun onSuccess(response: Any?) {
        isRoutelistFetched.set(true)
        if (response is GetRouteListModel) {
            if (response.status_code == 1 && response.data.Route?.size!! > 0) {
                routeListNavigator.onRouteListFetched(response)
            } else {
                isRoutelistFetched.set(true)
                routeListNavigator.onRouteFetchFailed(response.message)
            }
        }
    }

    override fun onError(errorBody: String) {
        isRoutelistFetched.set(true)
        routeListNavigator.onRouteFetchFailed(errorBody)
    }

    fun getRouteList() {

        if (Connectivity.isNetworkConnected(context)) {
            isRoutelistFetched.set(false)
            model = GetRouteListReqModel("742ad7d7-c437-4bf7-b499-6d9248cf5392")
            GlobalScope.launch(Dispatchers.Main) {
                try {
                    val service = ApiProvider.provideApi(context)!!
                    ApiRequest(context).apiRequest(
                        service.GetRoute(
                            model
                        ),
                        this@RouteListViewModel
                    )
                } catch (e: Exception) {
                    Log.e(RouteListViewModel::class.java.simpleName, e.message.toString())
//                    routeListNavigator.onRouteFetchFailed(context.getString(ProjectStrings.something_went_wrong))
                }

            }

        } else {

            isRoutelistFetched.set(true)
//            routeListNavigator.onRouteFetchFailed(context.getString(ProjectStrings.internet_connection_error))
        }

    }

    init {
        getRouteList()
    }

}