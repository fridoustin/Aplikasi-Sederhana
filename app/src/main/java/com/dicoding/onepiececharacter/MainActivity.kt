package com.dicoding.onepiececharacter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvOnePiece: RecyclerView
    private val list = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        rvOnePiece = findViewById(R.id.hal_utama)
        rvOnePiece.setHasFixedSize(true)

        list.addAll(getListChar())
        showRecyclerList()
    }

    private fun getListChar(): ArrayList<Character> {
        val dataName = resources.getStringArray(R.array.nama)
        val dataDescription = resources.getStringArray(R.array.deskripsi)
        val dataPhoto = resources.obtainTypedArray(R.array.foto)
        val listKarakter = ArrayList<Character>()
        for(i in dataName.indices) {
            val karakter = Character(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listKarakter.add(karakter)
        }
        return listKarakter
    }

    private fun showRecyclerList(){
        rvOnePiece.layoutManager = LinearLayoutManager(this)
        val listKarakter = ListKarakter(list)
        rvOnePiece.adapter = listKarakter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about_page -> {
                val aboutIntent = Intent(this@MainActivity, About::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}