package com.example.infobiz1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class StudentSignUpMainActivity : AppCompatActivity() {
    private lateinit var UserEmail: EditText
    private lateinit var UserPassword: EditText

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_sign_up_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        auth = FirebaseAuth.getInstance()

        UserEmail = findViewById(R.id.studentEditTextEmail)
        UserPassword = findViewById(R.id.studentEditTextPassword)

        val signUp: Button = findViewById(R.id.studentGoInButton)
        signUp.setOnClickListener(){
            signUp()
        }
        val register: Button = findViewById(R.id.studentRegisterButton)
        register.setOnClickListener(){
            openRegisterStudentActivity()
        }

    }

    public fun signUp() {
        val email = UserEmail.text.toString()
        val password = UserPassword.text.toString()

        if (email.equals("") || password.equals("")) {
            Toast.makeText(this, "Введите почту или пароль", Toast.LENGTH_SHORT).show()
        } else {
            auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Успешно", Toast.LENGTH_SHORT).show()
                        openTableActivity()
                    }
                    .addOnFailureListener(){
                        Toast.makeText(this, "Ошибка авторизации", Toast.LENGTH_SHORT).show()
                    }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        when(item.itemId){
            R.id.action_table->{
                Toast.makeText(this, "Авторизуйтесь", Toast.LENGTH_SHORT).show()
            }
            R.id.action_gallery->{
                Toast.makeText(this, "Авторизуйтесь", Toast.LENGTH_SHORT).show()
            }
            R.id.action_progress->{
                Toast.makeText(this, "Авторизуйтесь", Toast.LENGTH_SHORT).show()
            }
            R.id.action_planned->{
                Toast.makeText(this, "Авторизуйтесь", Toast.LENGTH_SHORT).show()
            }
            R.id.action_attend->{
                Toast.makeText(this, "Авторизуйтесь", Toast.LENGTH_SHORT).show()
            }
            android.R.id.home->{
                openMainActivity()
            }
        }
        return true
    }

    public fun openMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    public fun openRegisterStudentActivity(){
        val intent = Intent(this, StudentRegisterMainActivity::class.java)
        startActivity(intent)
    }

    public fun openTableActivity(){
        val intent = Intent(this, TableMainActivity::class.java)
        intent.putExtra("Number",2)
        startActivity(intent)
    }
}