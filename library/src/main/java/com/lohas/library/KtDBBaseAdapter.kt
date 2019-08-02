package com.lohas.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.util.*

/**
 * Created by zfw on 2019/7/31 17:51 auto
 */
open class KtDBBaseAdapter<T> : Adapter<KtDBBaseAdapter.DBViewHolder> {


    var mList: List<T>? = null
    var layoutId: Int? = null
    var brId: Int? = null

    var itemClick: ItemClick? = null

    constructor(mList: List<T>?, layoutId: Int?, brId: Int?) {
        this.mList = mList
        this.layoutId = layoutId
        this.brId = brId
    }

    fun updateData(items :  ArrayList<T>?){
        this.mList = items
        notifyDataSetChanged()
    }

    interface ItemClick {
        fun OnItemClick(v: View, position: Int)
    }

    fun setItemClickListener(itemClick: ItemClick) {
        this.itemClick = itemClick
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DBViewHolder {

        var binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), this!!.layoutId!!, parent, false
        )
        return DBViewHolder(binding)
    }

    override fun getItemCount(): Int = mList!!.size

    override fun onBindViewHolder(holder: DBViewHolder, position: Int) {
        val item = mList!![position]
        holder.binding.setVariable(this!!.brId!!, mList!![position])
        holder.binding.executePendingBindings()
        // item点击事件
        holder.binding.root.setOnClickListener {
            itemClick?.OnItemClick(holder.binding.root, position)
        }
        convert(holder.binding.root, item)
    }

     open fun convert(itemView : View?, item: T){

     }

    class DBViewHolder : ViewHolder {
        var binding: ViewDataBinding

        constructor(binding: ViewDataBinding) : super(binding.root) {
            this.binding = binding
        }



    }
}