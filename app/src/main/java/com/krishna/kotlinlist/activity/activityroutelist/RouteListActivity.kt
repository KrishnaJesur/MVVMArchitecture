package com.krishna.kotlinlist.activity.activityroutelist

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.krishna.kotlinlist.base.BaseActivity
import com.krishna.kotlinlist.databinding.ActivityRouteListBinding
import com.krishna.kotlinlist.util.ProjectLayouts
import com.smartschool.util.ToastUtils

class RouteListActivity : BaseActivity(), RouteListNavigator, childrenAdapterDelegate {

    lateinit var routeListBinding: ActivityRouteListBinding
    private lateinit var routeListViewModel: RouteListViewModel


    override fun onRouteListFetched(routelistmodel: GetRouteListModel) {
        val routeListAdapter = RouteListAdapter(routelistmodel.data.Route, this, this)
        routeListBinding.rvRoutelist.adapter = routeListAdapter
    }

    override fun onRouteFetchFailed(error: String) {

        ToastUtils.showShortToast(this, error)

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        routeListBinding = DataBindingUtil.setContentView(this, ProjectLayouts.activity_route_list)
        routeListViewModel = RouteListViewModel(this, this)
        routeListBinding.routelistViewModel = routeListViewModel

    }

    override fun onItemClick(child: GetRouteListModel.RouteItem) {

    }

}