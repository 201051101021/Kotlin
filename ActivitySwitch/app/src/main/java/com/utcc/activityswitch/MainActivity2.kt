package com.utcc.activityswitch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var sum = ""
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val TextViewNum = findViewById<TextView>(R.id.txtNum)


        val bundle = intent.extras
        if (bundle != null ){
            val receivedNum1 = bundle.getInt("num1")
            val receivedNum2 = bundle.getInt("num2")

            sum = (receivedNum1+receivedNum2).toString()
            TextViewNum.setText(sum)
            Toast.makeText(this,sum, Toast.LENGTH_LONG).show()
            }
        val buttonback = findViewById<Button>(R.id.btnBack)
        buttonback.setOnClickListener{
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
