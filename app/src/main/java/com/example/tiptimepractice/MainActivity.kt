package com.example.tiptimepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //listener for calculate button
        findViewById<Button>(R.id.bt_calculate).setOnClickListener {
            val costString: String = findViewById<EditText>(R.id.et_cost).text.toString()

            //if user entered a cost
            if (costString.isNotEmpty()) {
                val cost: Double = costString.toDouble()

                val radioGroup = findViewById<RadioGroup>(R.id.radio_group)

                //get text of selected Button
                val selBtnString = getSelectedButtonText(radioGroup)

                //if user selected a tip percent
                if (selBtnString.isNotEmpty()) {
                    //get the tip percentage listed on the button
                    val tipPercent: Double = selBtnString.filter { it.isDigit() }.toDouble()

                    val tipAmount: Double = calculateTip(cost, tipPercent)

                    //if round up switch is on
                    if (findViewById<Switch>(R.id.sw_round).isChecked) {
                        //round the tip amount and display it
                        findViewById<TextView>(R.id.tv_tip_amount).text = tipAmount.roundToInt().toString()
                    }
                    else {
                        //display the tip amount
                        findViewById<TextView>(R.id.tv_tip_amount).text = tipAmount.toString()
                    }
                }
            }
        }
    }

    //gets the text of the selected radio button
    fun getSelectedButtonText(radioGroup: RadioGroup): String {
        //get ID for selected button. Returns -1 if none selected in group
        val selectedBtnID = radioGroup.checkedRadioButtonId

        //if a button is selected
        if (selectedBtnID != -1) {
            val selectedBtn = findViewById<RadioButton>(selectedBtnID)
            return selectedBtn.text.toString()
        }
        else {
            return ""
        }
    }

    //calculate a tip
    fun calculateTip(cost: Double, tipPercent: Double): Double {
        return cost * (tipPercent / 100)
    }
}