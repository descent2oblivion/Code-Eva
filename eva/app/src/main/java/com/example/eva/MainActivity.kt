package com.example.eva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun lrn(view: View){
        var i = Intent(this, learn::class.java)
        startActivity(i)
    }

    fun ulds(view: View){
        var i = Intent(this, uploads::class.java)
        startActivity(i)
    }

    fun xp(view: View){
        var i = Intent(this, xper::class.java)
        startActivity(i)
    }

    fun ab(view: View){
        Toast.makeText(this, R.string.about, Toast.LENGTH_SHORT).show()
    }
}
