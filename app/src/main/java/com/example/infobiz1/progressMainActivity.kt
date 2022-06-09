package com.example.infobiz1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlin.properties.Delegates

class progressMainActivity : AppCompatActivity() {
    public var number by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        number = intent.getIntExtra("Number", 0)
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
            R.id.action_planned->{
                openPlannedActivity()
            }
            R.id.action_attend->{
                openAttendActivity()
            }
        }
        return true
    }

    public fun openTableActivity(){
        val intent = Intent(this, TableMainActivity::class.java)
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
}