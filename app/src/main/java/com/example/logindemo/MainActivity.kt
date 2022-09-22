package com.example.logindemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var counter : Int = 3
    private val mCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "onCreate Called", Toast.LENGTH_LONG).show()
        println("On Create Started")

        val eName = findViewById<EditText>(R.id.etName)
        val ePassword: EditText = findViewById(R.id.etPassword)
        val eLogin: Button = findViewById(R.id.btnLogin)
        val eAttemptsInfo: TextView = findViewById(R.id.tvInfo)
        val image: ImageView = findViewById(R.id.imageView2)
        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb)
        val stb = AnimationUtils.loadAnimation(this, R.anim.stb)
        eName.startAnimation(ttb)
        ePassword.startAnimation(ttb)
        eLogin.startAnimation(ttb)
        image.startAnimation(stb)

        eLogin.setOnClickListener(View.OnClickListener
        {
            val name = eName.text.toString()
            if (counter != 0) {
                if ((eName.text.toString()
                        .equals("admin", true)) && (ePassword.text.toString() == "1234")
                ) {
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("Username", name)
                    startActivity(intent)

                } else if ((eName.text.toString() != "Admin") && (ePassword.text.toString() != "1234")) {
                    Toast.makeText(
                        baseContext,
                        "Enter the Username and password",
                        Toast.LENGTH_SHORT
                    ).show()
                    counter--
                    eAttemptsInfo.text = "No of attempts remaining is : $counter"
                } else if ((eName.text.toString()
                        .equals("admin", true)) && (ePassword.text.toString() != "1234")
                ) {
                    Toast.makeText(
                        baseContext,
                        "Enter the correct Password",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    counter--
                    eAttemptsInfo.text = "No of attempts remaining is : $counter"
                } else if ((eName.text.toString() != "Admin") && (ePassword.text.toString() == "1234")) {
                    Toast.makeText(
                        baseContext,
                        "Enter the correct Username",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    counter--
                    eAttemptsInfo.text = "No of attempts remaining is : $counter"
                }
            } else

                eLogin.isEnabled = false
        })
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "onStart Called", Toast.LENGTH_LONG).show()
        println("On Start Started")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext, "onRestart Called", Toast.LENGTH_LONG).show()
        println("On Restart Started")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "onPause Called", Toast.LENGTH_LONG).show()
        println("On Pause Started")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "onResume Called", Toast.LENGTH_LONG).show()
        println("On On Resume Started")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext, "onStop Called", Toast.LENGTH_LONG).show()
        println("On On Stop Started")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "onDestroy Called", Toast.LENGTH_LONG).show()
        println("On Destroy Started")
    }
}
// counter--
//                    eAttemptsInfo.text = "No of attempts remaining is : $counter"
//                    if (counter == 0) {
//                        eLogin.isEnabled = false