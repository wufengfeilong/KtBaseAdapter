package com.lohas.ktbaseadapter

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lohas.library.KtDBBaseAdapter
import com.zagf.kotlinlearn.model.DBTestVM
import kotlinx.android.synthetic.main.activity_main_dbvm.*

class MainDBVMActivity : AppCompatActivity() {
    private var mViewModel: DBTestVM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dbvm)
        mViewModel = ViewModelProviders.of(this).get(DBTestVM::class.java)

        db_vm_rv.layoutManager = LinearLayoutManager(this)
        db_vm_rv.adapter = mViewModel?.dbAdapter
        mViewModel!!.getUserInfo()
        mViewModel?.dbAdapter?.setItemClickListener(object : KtDBBaseAdapter.ItemClick {
            override fun OnItemClick(v: View, position: Int) {
                Toast.makeText(this@MainDBVMActivity, "click$position", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
