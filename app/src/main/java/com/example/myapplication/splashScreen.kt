package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
            override fun run() {
                //val i = Intent(this@splashScreen,MainActivity::class.java)
                val i = Intent(this@splashScreen,MainActivity::class.java)
                startActivity(i)
                finish()
            }
        },3000)
    }
}