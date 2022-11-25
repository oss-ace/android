package com.example.friends


import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class FriendActivity : AppCompatActivity() {
    val db= Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend)

        //val col = db.collection("users")

        val md=db.collection("users").document("홍길동")

        val content=findViewById<TextView>(R.id.content)

        md.get().addOnSuccessListener {
                 //println("############# ${it.id}, ${it["content"]}")
                //text.text="${it.id}"
                //text2.text="${it["content"]}"
                 content.text="${it["content"]}"

             }

        val imageView = findViewById<ImageView>(R.id.image)


        val imageStr = "https://firebasestorage.googleapis.com/v0/b/fir-2022-2-af26a.appspot.com/o/user1.png?alt=media&token=77bc1633-28ba-43b2-bcaf-4d411798b486"
        Glide.with(this).load(imageStr).into(imageView)




    }
}