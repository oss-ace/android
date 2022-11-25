package com.example.friends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ThirdActivity : AppCompatActivity() {
    val db= Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        val col=db.collection("users")

        val profile1=findViewById<ImageView>(R.id.profile1)
        val profile2=findViewById<ImageView>(R.id.profile2)
        val profile3=findViewById<ImageView>(R.id.profile3)
        val profile4=findViewById<ImageView>(R.id.profile4)
        val profile5=findViewById<ImageView>(R.id.profile5)
        val profile6=findViewById<ImageView>(R.id.profile6)
        val profile7=findViewById<ImageView>(R.id.profile7)

        val name1=findViewById<TextView>(R.id.name1)
        val name2=findViewById<TextView>(R.id.name2)
        val name3=findViewById<TextView>(R.id.name3)
        val name4=findViewById<TextView>(R.id.name4)
        val name5=findViewById<TextView>(R.id.name5)
        val name6=findViewById<TextView>(R.id.name6)
        val name7=findViewById<TextView>(R.id.name7)

        val f_view_button1=findViewById<Button>(R.id.f_view_button1)
        val f_view_button2=findViewById<Button>(R.id.f_view_button2)
        val f_view_button3=findViewById<Button>(R.id.f_view_button3)
        val f_view_button4=findViewById<Button>(R.id.f_view_button4)
        val f_view_button5=findViewById<Button>(R.id.f_view_button5)
        val f_view_button6=findViewById<Button>(R.id.f_view_button6)
        val f_view_button7=findViewById<Button>(R.id.f_view_button7)

        var i :Int=0 //몇명인지
        val users= arrayOfNulls<String>(7) //널 배열
        //파이어스토어에서 팔로잉된 친구들 목록만 가져와 보여준다
        col.whereEqualTo("state",1).get()
         .addOnSuccessListener {
             for (d in it) {

                 users[i] = "${d.id}"
                 println("${users[i]}")
                 if(i==0){

                     name1.text="${d.id}"

                 }
                 if(i==1){
                     name2.text="${d.id}"

                 }
                 if(i==2){
                     name3.text="${d.id}"

                 }
                 if(i==3){
                     name4.text="${d.id}"

                 }
                 if(i==4){
                     name5.text="${d.id}"

                 }
                 if(i==5){
                     name6.text="${d.id}"

                 }
                 if(i==6){
                     name7.text="${d.id}"

                 }

                 i++;

             }

             for(j :Int in i+1..7){
                 if(j==1){
                     profile1.visibility=View.INVISIBLE
                     name1.visibility=View.INVISIBLE
                     f_view_button1.visibility=View.INVISIBLE
                 }
                 if(j==2){
                     profile2.visibility=View.INVISIBLE
                     name2.visibility=View.INVISIBLE
                     f_view_button2.visibility=View.INVISIBLE
                 }
                 if(j==3){
                     profile3.visibility=View.INVISIBLE
                     name3.visibility=View.INVISIBLE
                     f_view_button3.visibility=View.INVISIBLE
                 }
                 if(j==4){
                     profile4.visibility=View.INVISIBLE
                     name4.visibility=View.INVISIBLE
                     f_view_button4.visibility=View.INVISIBLE
                 }
                 if(j==5){
                     profile5.visibility=View.INVISIBLE
                     name5.visibility=View.INVISIBLE
                     f_view_button5.visibility=View.INVISIBLE
                 }
                 if(j==6){
                     profile6.visibility=View.INVISIBLE
                     name6.visibility=View.INVISIBLE
                     f_view_button6.visibility=View.INVISIBLE
                 }
                 if(j==7){
                     profile7.visibility=View.INVISIBLE
                     name7.visibility=View.INVISIBLE
                     f_view_button7.visibility=View.INVISIBLE
                 }
             }

             for(k :Int in 1..7){
                 if(name1.text=="홍길동"){
                     f_view_button1.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name1.text=="김영희"){
                     f_view_button1.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity2::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name1.text=="김철수"){
                     f_view_button1.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity3::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name1.text=="이지은"){
                     f_view_button1.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity4::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name1.text=="김고은"){
                     f_view_button1.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity5::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name1.text=="유디아"){
                     f_view_button1.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity6::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name1.text=="임지원"){
                     f_view_button1.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity7::class.java)
                         startActivity(secondIntent)
                     }
                 }



                 if(name2.text=="홍길동"){
                     f_view_button2.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name2.text=="김영희"){
                     f_view_button2.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity2::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name2.text=="김철수"){
                     f_view_button2.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity3::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name2.text=="이지은"){
                     f_view_button2.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity4::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name2.text=="김고은"){
                     f_view_button2.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity5::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name2.text=="유디아"){
                     f_view_button2.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity6::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name2.text=="임지원"){
                     f_view_button2.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity7::class.java)
                         startActivity(secondIntent)
                     }
                 }



                 if(name3.text=="홍길동"){
                     f_view_button3.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name3.text=="김영희"){
                     f_view_button3.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity2::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name3.text=="김철수"){
                     f_view_button3.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity3::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name3.text=="이지은"){
                     f_view_button3.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity4::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name3.text=="김고은"){
                     f_view_button3.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity5::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name3.text=="유디아"){
                     f_view_button3.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity6::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name3.text=="임지원"){
                     f_view_button3.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity7::class.java)
                         startActivity(secondIntent)
                     }
                 }


                 if(name4.text=="홍길동"){
                     f_view_button4.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name4.text=="김영희"){
                     f_view_button4.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity2::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name4.text=="김철수"){
                     f_view_button4.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity3::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name4.text=="이지은"){
                     f_view_button4.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity4::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name4.text=="김고은"){
                     f_view_button4.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity5::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name4.text=="유디아"){
                     f_view_button4.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity6::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name4.text=="임지원"){
                     f_view_button4.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity7::class.java)
                         startActivity(secondIntent)
                     }
                 }



                 if(name5.text=="홍길동"){
                     f_view_button5.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name5.text=="김영희"){
                     f_view_button5.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity2::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name5.text=="김철수"){
                     f_view_button5.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity3::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name5.text=="이지은"){
                     f_view_button5.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity4::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name5.text=="김고은"){
                     f_view_button5.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity5::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name5.text=="유디아"){
                     f_view_button5.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity6::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name5.text=="임지원"){
                     f_view_button5.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity7::class.java)
                         startActivity(secondIntent)
                     }
                 }




                 if(name6.text=="홍길동"){
                     f_view_button6.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name6.text=="김영희"){
                     f_view_button6.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity2::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name6.text=="김철수"){
                     f_view_button6.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity3::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name6.text=="이지은"){
                     f_view_button6.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity4::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name6.text=="김고은"){
                     f_view_button6.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity5::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name6.text=="유디아"){
                     f_view_button6.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity6::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name6.text=="임지원"){
                     f_view_button6.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity7::class.java)
                         startActivity(secondIntent)
                     }
                 }




                 if(name7.text=="홍길동"){
                     f_view_button7.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name7.text=="김영희"){
                     f_view_button7.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity2::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name7.text=="김철수"){
                     f_view_button7.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity3::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name7.text=="이지은"){
                     f_view_button7.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity4::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name7.text=="김고은"){
                     f_view_button7.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity5::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name7.text=="유디아"){
                     f_view_button7.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity6::class.java)
                         startActivity(secondIntent)
                     }
                 }
                 if(name7.text=="임지원"){
                     f_view_button7.setOnClickListener{
                         val secondIntent = Intent(this, FriendActivity7::class.java)
                         startActivity(secondIntent)
                     }
                 }






             }


         }




          // f_view_button1.setOnClickListener{
          //     val secondIntent = Intent(this, FriendActivity::class.java)
           //    startActivity(secondIntent)
          // }





    }
}