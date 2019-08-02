package com.zagf.kotlinlearn.model

import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lohas.ktbaseadapter.BR
import com.lohas.ktbaseadapter.R
import com.lohas.ktbaseadapter.UserInfo
import com.lohas.library.KtDBBaseAdapter

/**
 * Created by zfw on 2019/7/26 14:53 auto
 */
class DBTestVM: ViewModel() {
    val handle = object: Handler(){
        override fun handleMessage(msg: Message?) {
            dbAdapter.notifyDataSetChanged()
        }
    }
    var mList = ArrayList<UserInfo>()
    private var userVm = MutableLiveData<List<UserInfo>>()

    val dbAdapter: KtDBBaseAdapter<UserInfo> by lazy {
        KtDBBaseAdapter(mList, R.layout.db_vm_list_item, BR.userInfo1)
    }

    private fun getUIData() {
        mList?.add(UserInfo("1", "zhangsan", "123"))
        mList?.add(UserInfo("2", "lisi", "123"))
        mList?.add(UserInfo("3", "wangwu", "123"))
        mList?.add(UserInfo("1", "zhangsan", "123"))
        mList?.add(UserInfo("2", "lisi", "123"))
        mList?.add(UserInfo("3", "wangwu", "123"))
        mList?.add(UserInfo("1", "zhangsan", "123"))
        mList?.add(UserInfo("2", "lisi", "123"))
        mList?.add(UserInfo("3", "wangwu", "123"))
        mList?.add(UserInfo("1", "zhangsan", "123"))
        mList?.add(UserInfo("2", "lisi", "123"))
        mList?.add(UserInfo("3", "wangwu", "123"))
    }

    fun getUserInfo(){
        getUIData()
        userVm.value = mList

        Thread {
            Log.e("zfw", "进来子线程")
            Thread.sleep(3000)
//            userVm.value = UserInfo("222", "wangwu", "1111111")
            mList.removeAt(0)
            Log.e("zfw", "进来子线程3S")
            userVm.postValue(mList)
            Log.e("zfw", "进来子线程3S设置数据")
            //返回主线程执行
            handle.sendEmptyMessage(0)
        }.start()

    }
}