package com.example.infobiz1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import kotlin.properties.Delegates

class TableMainActivity : AppCompatActivity() {
    public var number by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table1_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        number = intent.getIntExtra("Number", 0)
        val time1:EditText = findViewById(R.id.timeEditView1)
        val time2:EditText = findViewById(R.id.timeEditView2)
        val time3:EditText = findViewById(R.id.timeEditView3)
        val robot1:EditText = findViewById(R.id.robotEditView1)
        val robot2:EditText = findViewById(R.id.robotEditView2)
        val robot3:EditText = findViewById(R.id.robotEditView3)
        val weeekend1:EditText = findViewById(R.id.weekendEditView1)
        val weeekend2:EditText = findViewById(R.id.weekendEditView2)
        val weeekend3:EditText = findViewById(R.id.weekendEditView3)

        if(number == 2){
            disable(time1)
            disable(time2)
            disable(time3)
            disable(robot1)
            disable(robot2)
            disable(robot3)
            disable(weeekend1)
            disable(weeekend2)
            disable(weeekend3)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        when(item.itemId){
            R.id.action_gallery->{
                openGalleryActivity()
            }
            R.id.action_progress->{
                openProgressActivity()
            }
            R.id.action_planned->{
                openPlannedActivity()
            }
            R.id.action_attend->{
                openAttendActivity()
            }
        }
        return true
    }

    public fun openProgressActivity(){
        val intent = Intent(this, progressMainActivity::class.java)
        intent.putExtra("Number", number)
        startActivity(intent)
    }

    public fun openPlannedActivity(){
        val intent = Intent(this, PlannedEventsMainActivity::class.java)
        intent.putExtra("Number", number)
        startActivity(intent)
    }
    public fun openGalleryActivity(){
        val intent = Intent(this, GalleryMainActivity::class.java)
        intent.putExtra("Number", number)
        startActivity(intent)
    }

    public fun openAttendActivity(){
        val intent = Intent(this, AttendMainActivity::class.java)
        intent.putExtra("Number", number)
        startActivity(intent)
    }

    public fun disable(editText: EditText){
        editText.setKeyListener(null);
    }
}