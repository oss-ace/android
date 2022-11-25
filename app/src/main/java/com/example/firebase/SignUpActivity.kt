package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firebase.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.nio.file.Files.find
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding

    lateinit var mAuth: FirebaseAuth

    private lateinit var mDbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 인증 초기화
        mAuth = Firebase.auth

        // db 초기화
        mDbRef = Firebase.database.reference

        binding.signupBtn.setOnClickListener{

            val name = binding.nameEdit.toString().trim()
            val Date = binding.dateEdit.text.toString().trim()
            val email = binding.emailEdit.text.toString().trim()
            val password = binding.passwordEdit.text.toString().trim()

            if (name.isEmpty()){
                Toast.makeText(this, "이름을 입력해주세요", Toast.LENGTH_LONG).show()
            }

            if (Date.isEmpty()){
                Toast.makeText(this, "생년월일을 입력해주세요", Toast.LENGTH_LONG).show()
            }
            if (email.isEmpty()){
                Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_LONG).show()
            }
            if (password.isEmpty()){
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_LONG).show()
            }

            else if (password.length>0){
                check_password(password)
            }
            else {
                signUp(name,Date,email,password)
            }


        }

    }

    /**
     * 회원가입
     */
   private fun signUp(name:String,Date:String,email:String, password:String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // 성공시 메인화면으로
                    Toast.makeText(this,"회원가입 성공",Toast.LENGTH_SHORT).show()
                    val intent:Intent = Intent(this@SignUpActivity,MainActivity::class.java)
                    startActivity(intent)
                    addUserToDatabase(name,Date,email,mAuth.currentUser?.uid!!)

                } else {
                    // 실패시 실행
                    Toast.makeText(this,"회원가입 실패",Toast.LENGTH_SHORT).show()

                }
            }
    }
    private fun addUserToDatabase(name:String,Date:String,email:String, uId:String){
        mDbRef.child("user").child(uId).setValue(User(name,Date,email,uId))
    }
    private fun check_password(password: String):Boolean {
        val pwPattern1 = "(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{8,20}$"
        val comp = Pattern.matches(pwPattern1, password)
        if (comp == false) {
            Toast.makeText(this, "비밀번호는 최소 6자리 이상 영문과 숫자로 구성 되어야 합니다", Toast.LENGTH_SHORT).show()
        }
        return comp

    }
}