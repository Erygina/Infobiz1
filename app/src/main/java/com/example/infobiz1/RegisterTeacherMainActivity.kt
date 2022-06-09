package com.example.infobiz1

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class RegisterTeacherMainActivity : AppCompatActivity() {

    private lateinit var UserName: EditText
    private lateinit var UserPassword: EditText
    private lateinit var ConfirmPass: EditText
    private lateinit var FILE_NAME1: String
    private lateinit var FILE_NAME2: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_teacher_activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val registerBtn: Button = findViewById(R.id.signInButton2)
        UserName = findViewById(R.id.teachertLogin)
        UserPassword = findViewById(R.id.teacherPassword)
        ConfirmPass = findViewById(R.id.confirmTeachEditText)
        registerBtn.setOnClickListener(){
            register()
        }
    }

    public fun register(){
        val name = UserName.getText().toString()
        val pass = UserPassword.getText().toString()
        val confirm = ConfirmPass.getText().toString()

        if(name.isEmpty() || pass.isEmpty() || confirm.isEmpty()){
            Toast.makeText(this, "Введите данные", Toast.LENGTH_SHORT).show()
        }
        else if (!pass.equals(confirm)){
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
        }
        else {
            openSignUpActivity()
        }
    }

    public fun openSignUpActivity(){
        val intent = Intent(this, TeacheSignUpActivityMainActivity::class.java)
        intent.putExtra("UserName", UserName.getText().toString())
        intent.putExtra("UserPassword", UserPassword.getText().toString())
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        if(item.itemId == android.R.id.home)
                openSignUpActivity()
        return true
    }

}