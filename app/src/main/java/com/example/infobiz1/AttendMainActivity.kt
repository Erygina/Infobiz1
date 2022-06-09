package com.example.infobiz1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import kotlin.properties.Delegates

class AttendMainActivity : AppCompatActivity() {
    public var number by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attend_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        number = intent.getIntExtra("Number", 0)
        val monday: EditText = findViewById(R.id.mondayEdit)
        val tuesday: EditText = findViewById(R.id.tuesdayEdit)
        val wednesday: EditText = findViewById(R.id.wednesdayEdit)
        val thursday: EditText = findViewById(R.id.thursdayEdit)
        val friday: EditText = findViewById(R.id.fridayEdit)
        val saturday: EditText = findViewById(R.id.saturdayEdit)
        if(number == 2){
            monday.setKeyListener(null);
            tuesday.setKeyListener(null);
            wednesday.setKeyListener(null);
            thursday.setKeyListener(null);
            friday.setKeyListener(null);
            saturday.setKeyListener(null);
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        when(item.itemId){
            R.id.action_table->{
                openTableActivity()
            }
            R.id.action_gallery->{
                openGalleryActivity()
            }
            R.id.action_progress->{
                openProgressActivity()
            }
            R.id.action_planned->{
                openPlannedActivity()
            }
        }
        return true
    }
    public fun openTableActivity(){
        val intent = Intent(this, TableMainActivity::class.java)
        intent.putExtra("Number", number)
        startActivity(intent)
    }

    public fun openProgressActivity(){
        val intent = Intent(this, progressMainActivity::class.java)
        intent.putExtra("Number", number)
        startActivity(intent)
    }
    public fun openGalleryActivity(){
        val intent = Intent(this, GalleryMainActivity::class.java)
        intent.putExtra("Number", number)
        startActivity(intent)
    }
    public fun openPlannedActivity(){
        val intent = Intent(this, PlannedEventsMainActivity::class.java)
        intent.putExtra("Number", number)
        startActivity(intent)
    }
}