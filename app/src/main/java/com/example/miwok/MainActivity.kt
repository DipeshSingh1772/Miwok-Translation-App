package com.example.miwok

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numbers.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, NumbersActivity::class.java)
            startActivity(intent)
        })
    }


    fun openFamilyMember(view: View) {
        val intent = Intent(this,FamilyActivity::class.java)
        startActivity(intent)
    }
    fun openColor(view: View) {
        val intent = Intent(this, ColorsActivity::class.java)
        startActivity(intent)
    }
    fun openPhrases(view: View) {
        val intent = Intent(this,PhrasesActivity::class.java)
        startActivity(intent)
    }
}