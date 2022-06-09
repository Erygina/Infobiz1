package com.example.infobiz1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader


class TeacheSignUpActivityMainActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var password: EditText
    lateinit var UserName: String
    lateinit var UserPassword: String
    var sPref: SharedPreferences? = null
    var sPref2: SharedPreferences? = null
    val SAVED_TEXT = "UserName"
    val SAVED_TEXT2 = "UserPassword"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teache_signup_activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        name = findViewById(R.id.editTextLogin)
        password = findViewById(R.id.editTextPassword)
        val goInButton: Button = findViewById(R.id.goInButton)
        val signInButton: Button = findViewById(R.id.signInButton)

        goInButton.setOnClickListener(){
            goInProcess()
        }
        signInButton.setOnClickListener(){
            openRegisterTeacherActivity()
        }
        UserName = intent.getStringExtra("UserName").toString()
        UserPassword = intent.getStringExtra("UserPassword").toString()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        when(item.itemId){
            R.id.action_table -> {
                Toast.makeText(this, "Авторизуйтесь", Toast.LENGTH_SHORT).show()
            }
            R.id.action_gallery -> {
                Toast.makeText(this, "Авторизуйтесь", Toast.LENGTH_SHORT).show()
            }
            R.id.action_progress -> {
                Toast.makeText(this, "Авторизуйтесь", Toast.LENGTH_SHORT).show()
            }
            R.id.action_planned -> {
                Toast.makeText(this, "Авторизуйтесь", Toast.LENGTH_SHORT).show()
            }
            R.id.action_attend -> {
                Toast.makeText(this, "Авторизуйтесь", Toast.LENGTH_SHORT).show()
            }
            android.R.id.home -> {
                openMainActivity()
            }
        }
        return true
    }

    public fun openMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    public fun openRegisterTeacherActivity(){
        val intent = Intent(this, RegisterTeacherMainActivity::class.java)
        startActivity(intent)
    }

    public fun goInProcess(){
        val inputName = name.text.toString()
        val inputPassword = password.text.toString()

        if(inputName.equals("") || inputPassword.equals("")){
            Toast.makeText(this, "Введите логин или пароль", Toast.LENGTH_SHORT).show()
        }
        else{
            if(inputName.equals(UserName) && inputPassword.equals(UserPassword)){
                Toast.makeText(this, "Успешно", Toast.LENGTH_SHORT).show()
                openTableActivity()
            }
            else{
                Toast.makeText(this, "Ошибка авторизации", Toast.LENGTH_SHORT).show()
            }
        }
    }
    public fun openTableActivity(){
        val intent = Intent(this, TableMainActivity::class.java)
        intent.putExtra("Number", 1)
        startActivity(intent)
    }

}


