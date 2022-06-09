package com.utcc.dynamicedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.updateLayoutParams

class MainActivity : AppCompatActivity() {
    override fun  onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val linearLayoutEditText = findViewById<LinearLayout>(R.id.linearLayoutEditText)


        val buttonShowText = findViewById<Button>(R.id.btnSowText)

        val editTextNameInLayout = EditText(this)
        editTextNameInLayout.setHint("Please enter your name")
        editTextNameInLayout.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        editTextNameInLayout.setPadding(20,20,20,20)

        val editTextSurnameInLayout = EditText(this)
        editTextSurnameInLayout.setHint("Please enter your surname")
        editTextSurnameInLayout.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        editTextSurnameInLayout.setPadding(20,20,20,20)

        linearLayoutEditText.addView(editTextNameInLayout)
        linearLayoutEditText.addView(editTextSurnameInLayout)

        val name = editTextNameInLayout.text
        val surname = editTextSurnameInLayout.text

        buttonShowText.setOnClickListener{
            Toast.makeText(this,name.toString()+" "+surname.toString(),
            Toast.LENGTH_SHORT).show()
        }
    }
}