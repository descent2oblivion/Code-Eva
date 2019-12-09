package com.example.eva.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.eva.Model.Code
import com.example.eva.R
import com.example.eva.xper
import com.example.eva.learn
import kotlinx.android.synthetic.main.row_layout.view.*
import kotlinx.android.synthetic.main.xper.view.*

class ListCodeAdapter (internal var activity: Activity,
                       internal var lstCode:List<Code>
): BaseAdapter() {

    internal var inflater: LayoutInflater
    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }



    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var rowView: View
        rowView = inflater.inflate(R.layout.row_layout,null)

        rowView.txt_Id.text = lstCode[position].id.toString()
        rowView.txt_Titulo.text = lstCode[position].titulo.toString()
        rowView.txt_Descripcion.text = lstCode[position].descripcion.toString()
        rowView.codeee.text = lstCode[position].codigo.toString()

        rowView.setOnClickListener(){

            var tx = rowView.codeee.text.toString()  //id del codigo

            //var codigo = select codigo from tabla where id_codigo = tx
            var ctx = convertView?.context
            var i = Intent(ctx, xper::class.java).apply {
                putExtra(EXTRA_MESSAGE, tx)
            }
            //i.putExtra(codigo, "cd")
            //y cargar el extra en el txtCode de la ventana xper

            if (ctx != null) {
                //Toast.makeText(ctx, tx, Toast.LENGTH_LONG).show()
                startActivity(ctx, i, null)
            }
        }
        return rowView
    }

    override fun getItem(position: Int): Any {
        return lstCode[position]
    }

    override fun getItemId(position: Int): Long {
        return lstCode[position].id.toLong()
    }

    override fun getCount(): Int {
        return lstCode.size
    }
}