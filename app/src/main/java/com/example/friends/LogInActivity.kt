package com.example.friends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.friends.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 인증 초기화
        mAuth = Firebase.auth

        // 로그인 버튼 이벤트
        binding.loginBtn.setOnClickListener {
            val email = binding.emailEdit.text.toString()
            val password = binding.passwordEdit.text.toString()

            if (email.isEmpty()){
                Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_LONG).show()
            }
            if (password.isEmpty()){
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_LONG).show()
            }
            else {
                login(email,password)
            }
        }

        // 회원가입 버튼 이벤트
        binding.signupBtn.setOnClickListener{
            val intent: Intent = Intent(this@LogInActivity,SignUpActivity::class.java)
            startActivity(intent)

        }
    }
    /*
    * 로그인
    * */
    private fun login(email:String, password:String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // 성공시 실행
                    val intent:Intent = Intent(this@LogInActivity,MainActivity::class.java)

                    startActivity(intent)

                    Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    // 실패시 실행
                    Toast.makeText(this,"로그인 실패",Toast.LENGTH_SHORT).show()
                    Log.d("LogIn","Error: ${task.exception}")
                }
            }
    }
}