package com.krishna.kotlinlist.activity.activityroutelist
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.krishna.kotlinlist.databinding.ItemRouteListRowBinding
import com.krishna.kotlinlist.util.ProjectLayouts


typealias childrenAdapterDelegate = RouteListAdapter.RouteListItemClick

class RouteListAdapter(
    private var route: ArrayList<GetRouteListModel.RouteItem>?,
    routeListActivity: RouteListActivity,
    private var childAdapterItemClick: RouteListItemClick
) : RecyclerView.Adapter<RouteListAdapter.RoutListAdapterHolder>() {

    lateinit var binding: ItemRouteListRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutListAdapterHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ProjectLayouts.item_route_list_row,
            parent,
            false
        )

        return RoutListAdapterHolder(binding)
    }

    override fun getItemCount(): Int {
        return route!!.size
    }


    override fun onBindViewHolder(holder: RoutListAdapterHolder, position: Int) {
        route?.get(position)?.let { holder.bindView(it, childAdapterItemClick) }
    }

    class RoutListAdapterHolder(var itemRoutBinding: ItemRouteListRowBinding) :
        RecyclerView.ViewHolder(itemRoutBinding.root) {

        fun bindView(
            child: GetRouteListModel.RouteItem,
            childAdapterItemClick: RouteListItemClick
        ) {
            itemRoutBinding.mRout = child
            itemRoutBinding.executePendingBindings()
            itemRoutBinding.tvTitle.text = child.PointName

        }

    }

    interface RouteListItemClick {
        fun onItemClick(
            child: GetRouteListModel.RouteItem
        )
    }

//    class RouteListViewHolder( var holderBinding: ItemRouteListRowBinding) :
//        RecyclerView.ViewHolder(holderBinding.root) {
//        fun bindView(
//            child: GetRouteListModel.RouteItem,
//            childAdapterItemClick: RouteListItemClick
//        ) {
//            holderBinding.tvTitle.text = child.PointName
//        }
//    }

}
