package com.utcc.edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtTextName = findViewById<EditText>(R.id.edtName)

        val buttonShowText = findViewById<Button>(R.id.btnShowText)

        buttonShowText.setOnClickListener{
            val inputText = edtTextName.text
            Toast.makeText(this, inputText,
            Toast.LENGTH_LONG).show()
        }

    }
}