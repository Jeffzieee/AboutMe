package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val accName : RealName = RealName("Jeffzieee")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.accName=accName
        binding.btnDone.setOnClickListener{
            addName(it)
        }
    }

    private fun addName(btnDone : View){
        binding.apply {
            invisibleText.text = "Real Name :- " + realName.text
            btnDone.visibility = View.GONE
            realName.visibility = View.GONE
            invisibleText.visibility = View.VISIBLE
            invalidateAll()
        }
        //Code to hide the keyboard input
        val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodMgr.hideSoftInputFromWindow(btnDone.windowToken,0)
    }
}