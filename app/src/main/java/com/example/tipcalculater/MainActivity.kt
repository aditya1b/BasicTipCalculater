package com.example.tipcalculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculater.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

lateinit var binding : ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringField = binding.edttxt.text.toString()
        val cost = stringField.toDouble()
        val selectedId = binding.Rbtns.checkedRadioButtonId
        val tipPercent = when(selectedId){
            R.id.twenty -> 0.20
            R.id.fifteen -> 0.15
            else -> 0.18
        }
        var tip = cost*tipPercent
        val checked = binding.swich.isChecked
        if(checked){
           tip =  kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance(Locale("en","in")).format(tip)
        binding.txtamnt.text = getString(R.string.amount,formattedTip)
    }
}