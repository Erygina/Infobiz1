package com.example.infobiz1

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.Settings
import android.text.Html
import android.text.Html.fromHtml
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar;
import java.net.URI


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //supportActionBar?.setTitle(("<font color = white>" + "<font size = actionBarTextSize>" + getString(R.string.ActionBar)))
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        val teacherButton: Button = findViewById(R.id.teacher_button)
        teacherButton.setOnClickListener(){
            openTeacherSignUpActivity()
        }
        val studentButton: Button = findViewById(R.id.student_button)
        studentButton.setOnClickListener(){
            openStudentSignUpActivity()
        }
    }

    override fun onCreateOptionsMenu(menu:Menu): Boolean {
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

        }
        return true
    }

    public fun openTeacherSignUpActivity(){
        val intent = Intent(this, TeacheSignUpActivityMainActivity::class.java)
        startActivity(intent)
    }

    public fun openStudentSignUpActivity(){
        val intent = Intent(this, StudentSignUpMainActivity::class.java)
        startActivity(intent)
    }

}