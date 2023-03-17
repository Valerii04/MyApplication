package com.example.myapplication

import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = mutableListOf<AnimalData>()

        val imgPathCat: String = "app/src/main/res/images/fph.jpg"
        val imgPathDog: String = "app/src/main/res/images/sph.jpg"
        val imgPathMouse: String = "app/src/main/res/images/tph.jpg"

        data.add(AnimalData("Мадагаскарська руконіжка", "Для конкретної інформації натисніть на кнопку ", R.drawable.fph, Color.RED, this.resources.getString(R.string.first_description)))
        data.add(AnimalData("Фенек", "Для конкретної інформації натисніть на кнопку ", R.drawable.sph, Color.RED, this.resources.getString(R.string.second_description)))
        data.add(AnimalData("Велика панда", "Для конкретної інформації натисніть на кнопку ", R.drawable.tph, Color.RED, this.resources.getString(R.string.third_description)))

        recyclerView.adapter = AnimalsRecyclerAdapter(data, this)
    }

    public fun startActivity(longDesc: String)
    {
        startActivity(Intent(this, SecondActivity::class.java).apply
        {
            putExtra("text", longDesc)
        })
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
    }
}