package com.lohas.library

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.lohas.library.KtBaseAdapter.KtViewHolder

/**
 * Created by zfw on 2019/7/30 15:15
 */
abstract class KtBaseAdapter<T>: Adapter<KtViewHolder> {


    private var mList: List<T>? = null
    var mContext: Context? = null
    private var mLayoutId:Int? = null
    var itemClick : ItemClick ?= null

    constructor(mList: List<T>?, mContext: Context?, mLayoutId: Int?) {
        this.mList = mList
        this.mContext = mContext
        this.mLayoutId = mLayoutId
    }

    interface ItemClick{
        fun OnItemClick(v: View, position: Int)
    }
    fun setItemClickListener(itemClick : ItemClick){
        this.itemClick = itemClick
    }
    fun updateData(items :  List<T>){
        this.mList = items
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KtViewHolder {
        val v = LayoutInflater.from(mContext).inflate(this!!.mLayoutId!!, parent, false)
        return KtViewHolder(v)
    }

    override fun onBindViewHolder(holder: KtViewHolder, position: Int) {
        val item = mList!![position]
        // item点击事件
        holder.itemView.setOnClickListener {
            itemClick!!.OnItemClick(holder.itemView, position)
        }
        convert(holder, item)
    }

    abstract fun convert(holder: KtViewHolder, item: T)

    override fun getItemCount(): Int = mList!!.size

    class KtViewHolder(itemView : View?):RecyclerView.ViewHolder(itemView!!){
        fun<T : View?> getView(id:Int):T{
            return itemView!!.findViewById<T>(id)
        }
    }
}