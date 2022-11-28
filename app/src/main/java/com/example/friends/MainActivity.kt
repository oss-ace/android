package com.example.friends

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class MainActivity : AppCompatActivity() {
    //val db= Firebase.firestore
    val db= Firebase.firestore
    var num: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val f_r_button=findViewById<Button>(R.id.f_r_button)
        val f_s_button=findViewById<Button>(R.id.f_s_button)

        val button=findViewById<Button>(R.id.button)

        val col=db.collection("titles")

        val profile1=findViewById<ImageView>(R.id.profile1)
        val profile2=findViewById<ImageView>(R.id.profile2)
        val profile3=findViewById<ImageView>(R.id.profile3)
        val profile4=findViewById<ImageView>(R.id.profile4)
        val profile5=findViewById<ImageView>(R.id.profile5)
        val profile6=findViewById<ImageView>(R.id.profile6)


        val title1=findViewById<TextView>(R.id.title1)
        val title2=findViewById<TextView>(R.id.title2)
        val title3=findViewById<TextView>(R.id.title3)
        val title4=findViewById<TextView>(R.id.title4)
        val title5=findViewById<TextView>(R.id.title5)
        val title6=findViewById<TextView>(R.id.title6)


        val f_view_button1=findViewById<Button>(R.id.f_view_button1)
        val f_view_button2=findViewById<Button>(R.id.f_view_button2)
        val f_view_button3=findViewById<Button>(R.id.f_view_button3)
        val f_view_button4=findViewById<Button>(R.id.f_view_button4)
        val f_view_button5=findViewById<Button>(R.id.f_view_button5)
        val f_view_button6=findViewById<Button>(R.id.f_view_button6)



        f_view_button1.setOnClickListener {
            val secondIntent = Intent(this, PostViewActivity::class.java)
            startActivity(secondIntent)

        }
        f_view_button2.setOnClickListener {
            val secondIntent = Intent(this, PostViewActivity2::class.java)
            startActivity(secondIntent)


        }
        f_view_button3.setOnClickListener {
            val secondIntent = Intent(this, PostViewActivity3::class.java)
            startActivity(secondIntent)


        }
        f_view_button4.setOnClickListener {
            val secondIntent = Intent(this, PostViewActivity4::class.java)
            startActivity(secondIntent)


        }
        f_view_button5.setOnClickListener {
            val secondIntent = Intent(this, PostViewActivity5::class.java)
            startActivity(secondIntent)


        }
        f_view_button6.setOnClickListener {
            val secondIntent = Intent(this, PostViewActivity6::class.java)
            startActivity(secondIntent)


        }


        //게시물 몇개있는지 검사후 num 값 셋팅
        col.whereGreaterThanOrEqualTo("number",0).get()
            .addOnSuccessListener {
                for(d in it) {
                    val s = "${d.id}"
                    if (s == "title1") {
                        num="${d["number"]}".toInt()
                        title1.text="게시글 1"
                        println("num===============${num}")
                    }
                    if(s=="title2"){
                        num="${d["number"]}".toInt()
                        title2.text="게시글 2"
                    }
                    if(s=="title3"){
                        num="${d["number"]}".toInt()
                        title3.text="게시글 3"
                    }
                    if(s=="title4"){
                        num="${d["number"]}".toInt()
                        title4.text="게시글 4"
                    }
                    if(s=="title5"){
                        num="${d["number"]}".toInt()
                        title5.text="게시글 5"
                    }
                    if(s=="title6"){
                        num="${d["number"]}".toInt()
                        title6.text="게시글 6"
                    }
                }
                //게시물 개수에 따라 게시물 보이게 하기
                if(num==0){

                    profile1.visibility=View.INVISIBLE
                    title1.visibility=View.INVISIBLE
                    f_view_button1.visibility=View.INVISIBLE

                    profile2.visibility=View.INVISIBLE
                    title2.visibility=View.INVISIBLE
                    f_view_button2.visibility=View.INVISIBLE

                    profile3.visibility=View.INVISIBLE
                    title3.visibility=View.INVISIBLE
                    f_view_button3.visibility=View.INVISIBLE

                    profile4.visibility=View.INVISIBLE
                    title4.visibility=View.INVISIBLE
                    f_view_button4.visibility=View.INVISIBLE

                    profile5.visibility=View.INVISIBLE
                    title5.visibility=View.INVISIBLE
                    f_view_button5.visibility=View.INVISIBLE

                    profile6.visibility=View.INVISIBLE
                    title6.visibility=View.INVISIBLE
                    f_view_button6.visibility=View.INVISIBLE

                }
                if(num==1){

                    profile2.visibility=View.INVISIBLE
                    title2.visibility=View.INVISIBLE
                    f_view_button2.visibility=View.INVISIBLE

                    profile3.visibility=View.INVISIBLE
                    title3.visibility=View.INVISIBLE
                    f_view_button3.visibility=View.INVISIBLE

                    profile4.visibility=View.INVISIBLE
                    title4.visibility=View.INVISIBLE
                    f_view_button4.visibility=View.INVISIBLE

                    profile5.visibility=View.INVISIBLE
                    title5.visibility=View.INVISIBLE
                    f_view_button5.visibility=View.INVISIBLE

                    profile6.visibility=View.INVISIBLE
                    title6.visibility=View.INVISIBLE
                    f_view_button6.visibility=View.INVISIBLE


                }
                if(num==2){
                    profile3.visibility=View.INVISIBLE
                    title3.visibility=View.INVISIBLE
                    f_view_button3.visibility=View.INVISIBLE

                    profile4.visibility=View.INVISIBLE
                    title4.visibility=View.INVISIBLE
                    f_view_button4.visibility=View.INVISIBLE

                    profile5.visibility=View.INVISIBLE
                    title5.visibility=View.INVISIBLE
                    f_view_button5.visibility=View.INVISIBLE

                    profile6.visibility=View.INVISIBLE
                    title6.visibility=View.INVISIBLE
                    f_view_button6.visibility=View.INVISIBLE

                }
                if(num==3){

                    profile4.visibility=View.INVISIBLE
                    title4.visibility=View.INVISIBLE
                    f_view_button4.visibility=View.INVISIBLE

                    profile5.visibility=View.INVISIBLE
                    title5.visibility=View.INVISIBLE
                    f_view_button5.visibility=View.INVISIBLE

                    profile6.visibility=View.INVISIBLE
                    title6.visibility=View.INVISIBLE
                    f_view_button6.visibility=View.INVISIBLE

                }
                if(num==4){
                    profile5.visibility=View.INVISIBLE
                    title5.visibility=View.INVISIBLE
                    f_view_button5.visibility=View.INVISIBLE

                    profile6.visibility=View.INVISIBLE
                    title6.visibility=View.INVISIBLE
                    f_view_button6.visibility=View.INVISIBLE

                }
                if(num==5){
                    profile6.visibility=View.INVISIBLE
                    title6.visibility=View.INVISIBLE
                    f_view_button6.visibility=View.INVISIBLE

                }

            }




        //게시물 개수에 따라 게시물 보이게 하기
       /* if(num==0){


            f_view_button1.isEnabled= false //버튼 비활성화

            f_view_button2.isEnabled= false

            f_view_button3.isEnabled= false

            f_view_button4.isEnabled= false

            f_view_button5.isEnabled= false

            f_view_button6.isEnabled= false
        }
        if(num==1){


            f_view_button2.isEnabled= false

            f_view_button3.isEnabled= false

            f_view_button4.isEnabled= false

            f_view_button5.isEnabled= false

            f_view_button6.isEnabled= false

        }
        if(num==2){

            f_view_button3.isEnabled= false

            f_view_button4.isEnabled= false

            f_view_button5.isEnabled= false

            f_view_button6.isEnabled= false
        }
        if(num==3){



            f_view_button4.isEnabled= false

            f_view_button5.isEnabled= false

            f_view_button6.isEnabled= false
        }
        if(num==4){


            f_view_button5.isEnabled= false

            f_view_button6.isEnabled= false
        }
        if(num==5){


            f_view_button6.isEnabled= false
        }
*/



        button.setOnClickListener {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1)



                val secondIntent = Intent(this, AddPhotoActivity::class.java)
                startActivity(secondIntent)


        }


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