package com.example.friends

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class PostViewActivity3 : AppCompatActivity() {
    val db= Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_view3)

        val md=db.collection("titles").document("title3")

        val title=findViewById<TextView>(R.id.title)
        val content=findViewById<TextView>(R.id.content)
        //val imageView = findViewById<ImageView>(R.id.image)

        val rootRef=Firebase.storage.reference

        val ref=rootRef.child("images/post3.png")

        ref.getBytes(Long.MAX_VALUE).addOnCompleteListener {
            if(it.isSuccessful){
                val bmp= BitmapFactory.decodeByteArray(it.result,0,it.result!!.size)
                val imageView = findViewById<ImageView>(R.id.image)
                imageView.setImageBitmap(bmp)
            }
        }


        md.get().addOnSuccessListener {

            content.text="${it["content"]}"
            title.text="${it["title"]}"

        }
    }
}