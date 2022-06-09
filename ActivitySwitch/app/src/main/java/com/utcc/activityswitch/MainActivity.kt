package com.utcc.activityswitch

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNum1 = findViewById<EditText>(R.id.edtNum1)
        val editTextNum2 = findViewById<EditText>(R.id.edtNum2)

        val buttonSendDatatoActivity02 =
            findViewById<Button>(R.id.btnADD)

        buttonSendDatatoActivity02.setOnClickListener{
            val intentToAct02 = Intent(this@MainActivity, MainActivity2::class.java)
            intentToAct02.putExtra("num1",editTextNum1.text.toString().toInt())
            intentToAct02.putExtra("num2",editTextNum2.text.toString().toInt())
        startActivity(intentToAct02)
        }

    }
}