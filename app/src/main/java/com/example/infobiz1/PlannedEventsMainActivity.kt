package com.example.infobiz1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.Delegates

class PlannedEventsMainActivity : AppCompatActivity() {
    private lateinit var desctiption: TextView
    public var number by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planned_events_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        number = intent.getIntExtra("Number", 0)

        desctiption = findViewById(R.id.descriptionTextView)
        desctiption.setText(
                "В школе 13 мая будут проходить соревнования роботов.\n" +
                "Мероприятие будет проходить в актовом зале. Соревнования состоится по двум видам: \"робо-сумо\" и \"прохождение по заданной траектории\". В обоих видах будет по несколько попыток. Главный критерий оценки конкурса - время, за которое роботы справятся с заданием.\n" +
                "\n" +
                "Робототехника - это новый вид занятий для детей, позволяющий вдохновить ребёнка вне школы и раскрыть его творческие таланты. Благодаря робототехники дети учатся строить различные моторизированные механизмы, разрабатывать программное обеспечение, знакомятся с основными принципами механики. А также узнают много нового и интересного.\n" +
                "Всех желающих принять участие ждем 13 мая в 14:00.")
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
    public fun openAttendActivity(){
        val intent = Intent(this, AttendMainActivity::class.java)
        intent.putExtra("Number", number)
        startActivity(intent)
    }
}