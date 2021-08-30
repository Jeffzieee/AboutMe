package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDone = findViewById<Button>(R.id.btn_Done)
        btnDone.setOnClickListener{
            addName(it)
        }
    }

    private fun addName(btnDone : View){
        val realName =findViewById<EditText>(R.id.real_name)
        val invisibleText = findViewById<TextView>(R.id.invisible_text)
        invisibleText.text = "Real Name :- "+realName.text
        btnDone.visibility= View.GONE
        realName.visibility = View.GONE
        invisibleText.visibility = View.VISIBLE

        //Code to hide the keyboard
        val inputMethodMgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodMgr.hideSoftInputFromWindow(btnDone.windowToken,0)
    }
}