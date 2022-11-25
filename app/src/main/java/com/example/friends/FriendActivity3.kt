package com.example.friends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FriendActivity3 : AppCompatActivity() {
    val db= Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend3)

        val md=db.collection("users").document("김철수")

        val content=findViewById<TextView>(R.id.content)

        md.get().addOnSuccessListener {
            //println("############# ${it.id}, ${it["content"]}")
            //text.text="${it.id}"
            //text2.text="${it["content"]}"
            content.text="${it["content"]}"

        }

        val imageView = findViewById<ImageView>(R.id.image)


        val imageStr = "https://firebasestorage.googleapis.com/v0/b/fir-2022-2-af26a.appspot.com/o/user3.png?alt=media&token=dd54d7b4-5570-4e8b-9082-307be936c47b"
        Glide.with(this).load(imageStr).into(imageView)
    }
}