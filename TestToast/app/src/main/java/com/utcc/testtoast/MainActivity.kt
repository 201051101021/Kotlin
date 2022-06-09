package com.utcc.testtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // การทำงานของ Button
        // 3 ชั้นตอน
        // ชั้นตอนที่ 1 - สรา้ง Object ชอง Button แล้วเชื่อมกับ Button ที่อบู่ใน Layout

        val buttonTestToast = findViewById<Button>(R.id.btnTestToast)

        //ขั้นตอนที่ 2 - ใส่ Listener ให้ buttonTestToast
        buttonTestToast.setOnClickListener{
            // ขั้นตอนที่ 3 - เมื่อ buttonTestToast ถูก Click
            // ให้แสดงข้อความ "Hello !!!" ด้วย Toast
            Toast.makeText(this,"Hello !!!",Toast.LENGTH_LONG).show()
        }
        val buttonShowName = findViewById<Button>(R.id.btnShowName)
        buttonTestToast.setOnClickListener{
            Toast.makeText(this@MainActivity,"สุวสันต์ วุฒิเขตต์",Toast.LENGTH_LONG).show()
        }
        fun showWelcome(view: View){
            Toast.makeText(this@MainActivity,"Welcome",Toast.LENGTH_SHORT).show()
        }


    }
}