package com.utcc.gridadd

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var string1 = ""
        var string2 = ""
        val array1 = arrayOf("0","1","2","3","4","5","6","7","8","9")
        val array2= arrayOf("10","20","30","40","50","60","70","80","90","100")
        var toast = Toast.makeText(this, "" , Toast.LENGTH_SHORT)
        fun Context.notify(message: String){
            if(toast != null){
                toast.cancel()
            }
            toast = Toast.makeText(this, message , Toast.LENGTH_SHORT)
            toast.show()
        }
        val grid = findViewById<GridView>(R.id.grid)
        val adap = ArrayAdapter(this,android.R.layout.simple_list_item_1,array1)
        grid.adapter = adap
        grid.setOnItemClickListener { adapterView, view, i, l ->
            string1 = array1[i]
        }

        val grid2 = findViewById<GridView>(R.id.grid2)
        val adap2 = ArrayAdapter(this,android.R.layout.simple_list_item_1,array2)
        grid2.adapter = adap2
        grid2.setOnItemClickListener { adapterView, view, i, l ->
            string2 = array2[i]
        }

        findViewById<Button>(R.id.btn1).setOnClickListener {
            notify(string1+string2)
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            notify((string1.toInt()+string2.toInt()).toString())
        }

    }
}