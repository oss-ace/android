package com.example.friends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class MainActivity : AppCompatActivity() {
    //val db= Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val f_r_button=findViewById<Button>(R.id.f_r_button)
        val f_s_button=findViewById<Button>(R.id.f_s_button)




        f_r_button.setOnClickListener {
            val secondIntent = Intent(this, SecondActivity2::class.java)
            startActivity(secondIntent)

        }

        f_s_button.setOnClickListener{
            val thirdIntent=Intent(this,ThirdActivity::class.java)
            startActivity(thirdIntent)
        }
    }
}