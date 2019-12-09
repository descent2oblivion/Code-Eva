package com.example.eva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.eva.Adapter.ListCodeAdapter
import com.example.eva.DBHelper.DBHelper
import com.example.eva.Model.Code
import kotlinx.android.synthetic.main.learn.*

class learn : AppCompatActivity() {
    internal  lateinit var db: DBHelper
    internal var lstCode:List<Code> = ArrayList<Code>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn)
        db = DBHelper(this)
        refreshData()
    }
    private fun refreshData(){
        lstCode = db.allCode
        val adapter = ListCodeAdapter(this@learn,lstCode)
        list_Code.adapter = adapter
    }
}
