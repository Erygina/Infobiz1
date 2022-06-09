package com.example.infobiz1

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth


class StudentRegisterMainActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmEditText: EditText
    private lateinit var registerBtn: Button

    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_register_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        auth = FirebaseAuth.getInstance()

        emailEditText = findViewById(R.id.studentLogin)
        passwordEditText = findViewById(R.id.studentPassword2)
        confirmEditText = findViewById(R.id.confirmStudentEditText)
        registerBtn = findViewById(R.id.studentSignInButton2)

        registerBtn.setOnClickListener(){
            register()
        }

    }

    public fun register(){
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirm = confirmEditText.text.toString()

        if(email.isEmpty() || password.isEmpty() || confirm.isEmpty()){
            Toast.makeText(this, "Введите данные", Toast.LENGTH_SHORT).show()
        }
        else if (!password.equals(confirm)){
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
        }
        else{
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener() {
                    Toast.makeText(this, "Успешно", Toast.LENGTH_SHORT).show()
                    openSignUpActivity()
                }

        }
    }

    public fun onComplete(task: Task<AuthResult>){
        if(task.isSuccessful)
            Toast.makeText(this, "Успешно", Toast.LENGTH_SHORT).show()
    }

    public fun openSignUpActivity(){
        val intent = Intent(this, StudentSignUpMainActivity::class.java)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        if(item.itemId == android.R.id.home)
            openSignUpActivity()
        return true
    }
}