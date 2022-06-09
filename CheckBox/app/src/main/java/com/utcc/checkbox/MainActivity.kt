package com.utcc.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val soup = findViewById<CheckBox>(R.id.chkSoup)
        val salad = findViewById<CheckBox>(R.id.chkSalad)
        val steak = findViewById<CheckBox>(R.id.chkSteak)
        val pannacotta = findViewById<CheckBox>(R.id.chkPannaCotta)
        var totalAmount: Int = 0
        val btncal = findViewById<Button>(R.id.btnCalculate)
        val btncalnet = findViewById<Button>(R.id.btnCalNet)
        val radioGroup1 = findViewById<RadioGroup>(R.id.rdGroup1)
        val std = findViewById<RadioButton>(R.id.rdstd)
        val alumni = findViewById<RadioButton>(R.id.rdAlumni)
        val other = findViewById<RadioButton>(R.id.rdOther)


        soup.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    this, "Soup selected",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this, "Soup not selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        salad.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    this, "Salad selected",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this, "Salad not selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        steak.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    this, "Steak selected",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this, "Steak not selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        pannacotta.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    this, "Panna Cotta selected",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this, "Panna Cotta not selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        btncal.setOnClickListener {
            val expenseresult = StringBuilder()
            totalAmount = 0


            expenseresult.append("*** Selected Menus: ***")
            if (soup.isChecked) {
                expenseresult.append("\nSoup 50 Baht")
                totalAmount += 50
            }
            if (salad.isChecked) {
                expenseresult.append("\nSalad 85 Baht")
                totalAmount += 85
            }
            if (steak.isChecked) {
                expenseresult.append("\nSteak 160 Baht")
                totalAmount += 160
            }
            if (pannacotta.isChecked){
                expenseresult.append("\nSteak 100 Baht")
                totalAmount += 100
            }

            expenseresult.append("\nTotal: " + totalAmount + " Baht")
            expenseresult.append("\n*** Bon Appetit ***")
            Toast.makeText(this,expenseresult.toString(),
            Toast.LENGTH_SHORT).show()
        }

        radioGroup1.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            Toast.makeText(
                this, "${radioButton.text}",
                Toast.LENGTH_SHORT
            ).show()
        }

        btncalnet.setOnClickListener {
            val netresult = StringBuilder()
            var net:Double

            if (std.isChecked) {
               net = totalAmount*0.75
                netresult.append("Net Price is: " + net + " Baht")
            }
            if (alumni.isChecked) {
               net = totalAmount*0.85
                netresult.append("Net Price is: " + net + " Baht")
            }
            if (other.isChecked) {
               net = totalAmount*0.95
                netresult.append("Net Price is: " + net + " Baht")
            }
            Toast.makeText(this,netresult.toString(),
                Toast.LENGTH_SHORT).show()
        }
    }
}
