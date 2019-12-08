package com.example.eva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.xper.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.lang.Exception
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager



class xper : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.xper)
    }

    fun run(view : View){


        try{
            with(ScriptEngineManager().getEngineByName("rhino")){
                var z = eval("print('elo uorl')")
                //txtRes.setText(z)
            }
        }
        catch (ex: Exception){
            Toast.makeText(this, "nel", Toast.LENGTH_LONG).show()
            txtRes.setText(ex.message.toString())
        }
    }
}