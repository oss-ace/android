package com.example.friends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FriendActivity5 : AppCompatActivity() {
    val db= Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend5)

        val md=db.collection("users").document("김고은")

        val content=findViewById<TextView>(R.id.content)

        md.get().addOnSuccessListener {
            //println("############# ${it.id}, ${it["content"]}")
            //text.text="${it.id}"
            //text2.text="${it["content"]}"
            content.text="${it["content"]}"

        }

        val imageView = findViewById<ImageView>(R.id.image)


        val imageStr = "https://firebasestorage.googleapis.com/v0/b/fir-2022-2-af26a.appspot.com/o/user5.png?alt=media&token=efe8749c-0034-48ef-8864-a6d62f4cc677"
        Glide.with(this).load(imageStr).into(imageView)
    }
}