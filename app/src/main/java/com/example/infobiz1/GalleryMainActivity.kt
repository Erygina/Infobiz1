package com.example.infobiz1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import kotlin.properties.Delegates

class GalleryMainActivity : AppCompatActivity() {
    public var number by Delegates.notNull<Int>()
    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var image3: ImageView
    private lateinit var image4: ImageView
    private lateinit var image5: ImageView
    private lateinit var image6: ImageView
    private lateinit var image7: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_main)
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

    public fun openProgressActivity(){
        val intent = Intent(this, progressMainActivity::class.java)
        intent.putExtra("Number", number)
        startActivity(intent)
    }
    public fun openAttendActivity(){
        val intent = Intent(this, AttendMainActivity::class.java)
        intent.putExtra("Number", number)
        startActivity(intent)
    }
}