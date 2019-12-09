package com.example.eva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.eva.Adapter.ListCodeAdapter
import com.example.eva.DBHelper.DBHelper
import com.example.eva.Model.Code
import kotlinx.android.synthetic.main.learn.*
import kotlinx.android.synthetic.main.uploads.*

class  uploads : AppCompatActivity() {
    internal  lateinit var db: DBHelper
    internal var lstCode:List<Code> = ArrayList<Code>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.uploads)

        db = DBHelper(this)

        BtnUpload.setOnClickListener{
            val cd = Code(
                Titulo.text.toString(),
                Descripcion.text.toString(),
                CodigoInput.text.toString()
            )
            db.addCode(cd)
            Toast.makeText(this,R.string.code_uploaded,Toast.LENGTH_SHORT).show()
        }


       /* btn_update.setOnClickListener{
            val person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_email.text.toString()
            )
            db.updatePerson(person)
            refreshData()
        }*/
       /* btn_delete.setOnClickListener{
            val cod = Code(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_email.text.toString()
            )
            db.deletePerson(person)
            refreshData()
        }*/
    }


}