package com.example.friends


import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_add_photo.*
import java.text.SimpleDateFormat
import java.util.*


class AddPhotoActivity : AppCompatActivity() {
    var PICK_IMAGE_FROM_ALBUM = 0
    var storage: FirebaseStorage? = null
    var photoUri: Uri? = null
    val db= Firebase.firestore
    var num: Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_photo)

        //1. 레퍼런스 가져오기

        val col=db.collection("titles")

        //게시물 몇개있는지 검사후 num 값 셋팅
        col.whereGreaterThanOrEqualTo("number",0).get()
            .addOnSuccessListener {
                for(d in it) {
                    val s = "${d.id}"
                    if (s == "title1") {
                        num="${d["number"]}".toInt()
                    }
                    if(s=="title2"){
                        num="${d["number"]}".toInt()
                    }
                    if(s=="title3"){
                        num="${d["number"]}".toInt()
                    }
                    if(s=="title4"){
                        num="${d["number"]}".toInt()
                    }
                    if(s=="title5"){
                        num="${d["number"]}".toInt()
                    }
                    if(s=="title6"){
                        num="${d["number"]}".toInt()
                    }
                }
            }



        //스토리지 초기화
        storage = FirebaseStorage.getInstance()

        //앨범열기
        var photoPickerIntent = Intent(Intent.ACTION_PICK)
        photoPickerIntent.type = "image/*"
        startActivityForResult(photoPickerIntent, PICK_IMAGE_FROM_ALBUM)

        //버튼에 이벤트넣기
            var button2 = findViewById<Button>(R.id.button2)
            button2.setOnClickListener{
                num++
                contentUpload()
               // num++
                //에딧 텍스트 값 얻기
                val edit_title=edit_title.text.toString()
                val edit_content=edit_content.text.toString()

                val itemMap=hashMapOf(
                    "title" to edit_title,
                    "content" to edit_content,
                    "number" to num  //num으로 몇번째 게시물인지 확인

                )

                //id 값 title1,2,3,...등
                var title="title${num}"
                col.document(title).set(itemMap)



                val secondIntent = Intent(this, MainActivity::class.java)
                startActivity(secondIntent)
            }


    }
    //var image = findViewById<ImageView>(R.id.image)


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_FROM_ALBUM) {
            if (resultCode == Activity.RESULT_OK) { // this is path to the selected image
                var image = findViewById<ImageView>(R.id.image)
                photoUri=data?.data
               image.setImageURI(photoUri)

            } else { //exit the addPhotoActivity if you leave the album without selecting it
               finish()
            }
        }
    }

    fun contentUpload() {
        //make filename
        //var timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        var imageFileName = "post" + num + ".png"

        var storageRef = storage?.reference?.child("images")?.child(imageFileName)
        //file upload
        storageRef?.putFile(photoUri!!)?.addOnSuccessListener {
            Toast.makeText(this, "이미지 업로드 완료", Toast.LENGTH_LONG).show()
        }

    }


}