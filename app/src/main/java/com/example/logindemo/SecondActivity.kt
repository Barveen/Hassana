package com.example.logindemo

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)
        val intent = intent
        val name = intent.getStringExtra("Username")

        // showing the back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //textview
        val resultTv = findViewById<TextView>(R.id.textView)
        //setText
        resultTv.text = "Username: $name"
        val image : ImageView = findViewById(R.id.imageView3)
        val images : ImageView = findViewById(R.id.imageView)
        val stb = AnimationUtils.loadAnimation(this,R.anim.stb)
        image.startAnimation(stb)
        images.startAnimation(stb)
    }
    override fun onNavigateUp(): Boolean {
        finish()
        return true
    }
}



//tools:context=".MainActivity"