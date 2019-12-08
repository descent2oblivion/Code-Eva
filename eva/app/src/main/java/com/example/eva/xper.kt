package com.example.eva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.xper.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.mozilla.javascript.Context
import java.lang.Exception



class xper : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.xper)
    }

    fun ran(view : View){

        /*var engine = ScriptEngineManager().getEngineByName("rhino")
        var Operation : String? = txtCode.getText().toString()!!

        try {
            doAsync {
                var result = engine.eval(Operation, );
                Log.d("Calculator", "Operation: " + Operation + " result: " + result);
                uiThread {
                    txtRes.setText(result.toString())
                }
            }
        } catch (ex : Exception) {
            Log.d("Calculator", " ScriptEngine error: " + ex.message);
            txtRes.setText(ex.message)
        }*/
    }

    fun run(view : View){

        var rhino = Context.enter()
        // turn off optimization to work with android
        rhino.optimizationLevel = -1

        var evaluation = txtCode.getText().toString()

        try {
            var scope = rhino.initStandardObjects()
            var result : String = rhino.evaluateString(scope, evaluation, "JavaScript", 1, null).toString()
            txtRes.setText(result)
        }
        catch(e : Exception){
            txtRes.setText(e.message)
        }
        finally {
            Context.exit()
        }
    }
}