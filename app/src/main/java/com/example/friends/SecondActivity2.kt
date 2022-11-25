package com.example.friends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.sql.DriverManager.println


class SecondActivity2 : AppCompatActivity() {
    val db= Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)

        val f_button1=findViewById<Button>(R.id.f_button1)
        val f_button2=findViewById<Button>(R.id.f_button2)
        val f_button3=findViewById<Button>(R.id.f_button3)
        val f_button4=findViewById<Button>(R.id.f_button4)
        val f_button5=findViewById<Button>(R.id.f_button5)
        val f_button6=findViewById<Button>(R.id.f_button6)
        val f_button7=findViewById<Button>(R.id.f_button7)

        val f_cancel_button1=findViewById<Button>(R.id.f_view_button1)
        val f_cancel_button2=findViewById<Button>(R.id.f_view_button2)
        val f_cancel_button3=findViewById<Button>(R.id.f_view_button3)
        val f_cancel_button4=findViewById<Button>(R.id.f_view_button4)
        val f_cancel_button5=findViewById<Button>(R.id.f_view_button5)
        val f_cancel_button6=findViewById<Button>(R.id.f_view_button6)
        val f_cancel_button7=findViewById<Button>(R.id.f_view_button7)




        //1. 레퍼런스 가져오기
        val md=db.collection("users").document("김고은")
        val col=db.collection("users")


        //2. 접근하기 (읽기, 쓰기)
        md.get().addOnSuccessListener {
            println("############# ${it.id}, ${it["content"]}")
        }

        col.get().addOnSuccessListener {
            for (d in it){
                println("------------ ${d.id}, ${d["content"]}")
           }
       }




        //처음에 에뮬레이터 실행시 firestore에서 상태 state 읽어와 기존 친구 추천 팔로우 ,언팔로우 관계 셋팅
        col.whereEqualTo("state",1).get()
            .addOnSuccessListener {
                for(d in it){
                    val s="${d.id}"
                    if(s=="홍길동"){
                        f_button1.text="팔로잉"
                        f_button1.isEnabled=false //버튼 비활성화
                    }
                    else if(s=="김영희"){
                        f_button2.text="팔로잉"
                        f_button2.isEnabled=false //버튼 비활성화

                    }
                    else if(s=="김철수"){
                        f_button3.text="팔로잉"
                        f_button3.isEnabled=false //버튼 비활성화

                    }
                    else if(s=="이지은"){
                        f_button4.text="팔로잉"
                        f_button4.isEnabled=false //버튼 비활성화

                    }
                    else if(s=="김고은"){
                        f_button5.text="팔로잉"
                        f_button5.isEnabled=false //버튼 비활성화

                    }
                    else if(s=="유디아"){
                        f_button6.text="팔로잉"
                        f_button6.isEnabled=false //버튼 비활성화

                    }
                    else if(s=="임지원"){
                        f_button7.text="팔로잉"
                        f_button7.isEnabled=false //버튼 비활성화

                    }
                }
            }



        f_button1.setOnClickListener {
            val itemMap=hashMapOf(
                "content" to "오늘 먹은 음식!! 맛있었다 ~! 또 먹고 싶다   내일은 파스타를 먹어봐야지!!",
                "state" to 1 //state 1이면 팔로우 상태
             )

            //user1이라는 아이디가 만들어짐
            col.document("홍길동").set(itemMap)
            f_button1.text="팔로잉"
            f_button1.isEnabled=false //버튼 비활성화
        }
        f_button2.setOnClickListener {
            val itemMap=hashMapOf(
                "content" to "내가 좋아하는 풍경사진!! 놀러가고 싶다~~~!  이번엔 어디로 떠날까??",
                "state" to 1 //state 1이면 팔로우 상태
            )


            col.document("김영희").set(itemMap)
            f_button2.text="팔로잉"
            f_button2.isEnabled=false //버튼 비활성화

        }
        f_button3.setOnClickListener {
            val itemMap=hashMapOf(
                "content" to "여행가고 싶다!! 이번엔 바다 보러 가볼까~~~~ 재밌겠다~~~~",
                "state" to 1 //state 1이면 팔로우 상태
            )


            col.document("김철수").set(itemMap)
            f_button3.text="팔로잉"
            f_button3.isEnabled=false //버튼 비활성화

        }
        f_button4.setOnClickListener {
            val itemMap=hashMapOf(
                "content" to "연말 분위기 크리스마스 ~~ 겨울되면 크리스마스 트리를 꾸며야지!",
                "state" to 1 //state 1이면 팔로우 상태
            )


            col.document("이지은").set(itemMap)
            f_button4.text="팔로잉"
            f_button4.isEnabled=false //버튼 비활성화

        }
        f_button5.setOnClickListener {
            val itemMap=hashMapOf(
                "content" to "내가 좋아하는 망고, 망고 먹고싶다! 망고는 먹어도 먹어도 맛있다~~",
                "state" to 1 //state 1이면 팔로우 상태
            )


            col.document("김고은").set(itemMap)
            f_button5.text="팔로잉"
            f_button5.isEnabled=false //버튼 비활성화

        }
        f_button6.setOnClickListener {
            val itemMap=hashMapOf(
                "content" to "오늘의 할일: 1.강의보기 2.과제하기 3.코딩하기  언제 다하지...?? ㅠㅠ",
                "state" to 1 //state 1이면 팔로우 상태
            )


            col.document("유디아").set(itemMap)
            f_button6.text="팔로잉"
            f_button6.isEnabled=false //버튼 비활성화

        }
        f_button7.setOnClickListener {
            val itemMap=hashMapOf(
                "content" to "바다 보러가고싶다!! 어느 바다로 가는게 좋을까~~?? 찾아봐야지!",
                "state" to 1 //state 1이면 팔로우 상태
            )


            col.document("임지원").set(itemMap)
            f_button7.text="팔로잉"
            f_button7.isEnabled=false //버튼 비활성화

        }


        f_cancel_button1.setOnClickListener {
            col.document("홍길동").delete()
                .addOnSuccessListener { println("user1삭제") }
            f_button1.text="팔로우"
            f_button1.isEnabled=true //버튼 활성화

        }
        f_cancel_button2.setOnClickListener {
            col.document("김영희").delete()
                .addOnSuccessListener { println("user2삭제") }
            f_button2.text="팔로우"
            f_button2.isEnabled=true //버튼 활성화

        }
        f_cancel_button3.setOnClickListener {
            col.document("김철수").delete()
                .addOnSuccessListener { println("user3삭제") }
            f_button3.text="팔로우"
            f_button3.isEnabled=true //버튼 활성화

        }
        f_cancel_button4.setOnClickListener {
            col.document("이지은").delete()
                .addOnSuccessListener { println("user4삭제") }
            f_button4.text="팔로우"
            f_button4.isEnabled=true //버튼 활성화

        }
        f_cancel_button5.setOnClickListener {
            col.document("김고은").delete()
                .addOnSuccessListener { println("user5삭제") }
            f_button5.text="팔로우"
            f_button5.isEnabled=true //버튼 활성화

        }
        f_cancel_button6.setOnClickListener {
            col.document("유디아").delete()
                .addOnSuccessListener { println("user6삭제") }
            f_button6.text="팔로우"
            f_button6.isEnabled=true //버튼 활성화

        }
        f_cancel_button7.setOnClickListener {
            col.document("임지원").delete()
                .addOnSuccessListener { println("user7삭제") }
            f_button7.text="팔로우"
            f_button7.isEnabled=true //버튼 활성화

        }








    }
}