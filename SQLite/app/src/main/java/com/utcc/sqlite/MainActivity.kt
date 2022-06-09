package com.utcc.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.edtName)
        val editTextAge = findViewById<EditText>(R.id.edtAge)
        val editTextGender = findViewById<EditText>(R.id.edtGender)


        val db = DatabaseHandler(this@MainActivity)
        val buttonInsert = findViewById<Button>(R.id.btnInsert)
        val buttonRead = findViewById<Button>(R.id.btnRead)

        val textViewResult = findViewById<TextView>(R.id.txtResult)

        buttonInsert.setOnClickListener {
            if (editTextName.text.toString().isNotEmpty() &&
                editTextAge.text.toString().isNotEmpty() &&
                editTextGender.text.toString().isNotEmpty()
            ) {
                val user = User(editTextName.text.toString(), editTextAge.text.toString().toInt(), editTextGender.text.toString())
                db.insertData(user)
                // Clear fields
                editTextName.text.clear()
                editTextAge.text.clear()
                editTextGender.text.clear()
            }
            else {
                Toast.makeText(this@MainActivity, "Please Fill All Data's",
                                Toast.LENGTH_SHORT).show()
            }
        }
        buttonRead.setOnClickListener {
            val data = db.readData()
            textViewResult.text = ""
            for (i in 0 until data.size) {
                textViewResult.append(
                    data[i].id.toString() + " " + data[i].name + " " + data[i].age + " " + data[i].gender +"\n"
                )
            }
        }
    }

}

