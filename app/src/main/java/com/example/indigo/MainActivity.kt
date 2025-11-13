package com.example.indigo

import android.os.Build
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnItemClickListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lista = listOf(
            Flight("Indigo", "DEL", "06:30", "BLR", "10:45", "04h 15m", "5,319"),
            Flight("Vistara", "DEL", "07:30", "BLR", "11:45", "02h 15m", "6,319"),
            Flight("Spicejet", "DEL", "09:00", "BLR", "12:15", "03h 00m", "7,319"),
            Flight("Indigo", "DEL", "11:20", "BLR", "14:00", "03h 15m", "7,019"),
            Flight("Emirates", "DEL", "15:00", "BLR", "18:30", "01h 45m", "10,319"),
            Flight("Indigo", "DEL", "17:30", "BLR", "20:00", "03h 20m", "5,812"),
            Flight("Indigo", "DEL", "21:45", "BLR", "23:45", "04h 15m", "4,119")
        )

        val rec = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = Adapter(lista, this)

        rec.adapter = adapter
        rec.layoutManager = LinearLayoutManager(this)

    }

    override fun onItemClick(item: Flight) {
        val fragment = FlightDetailsFragment()

        val bundle = Bundle().apply {
            putString("depCode", item.departureCode)
            putString("arrCode", item.arrivalCode)
            putString("duration", item.duration)
            putString("depTime", item.departureTime)
        }
        fragment.arguments = bundle

        //supportFragmentManager.commit {
        //    replace(R.id.itemDetailsFragContainer, fragment)
        //    addToBackStack(null)
        //}
    }

}