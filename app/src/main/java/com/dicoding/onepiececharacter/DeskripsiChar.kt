package com.dicoding.onepiececharacter

import android.app.Person
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DeskripsiChar : AppCompatActivity() {

    companion object {
        const val char ="char"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desc)

        val dataChar = if(Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Character>(char, Character::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Character>(char)
        }

        val namaKarakter = findViewById<TextView>(R.id.nama_karakter_desc)
        val descKarakter = findViewById<TextView>(R.id.deskirpsi_desc)
        val fotoKarakter = findViewById<ImageView>(R.id.foto_karakter_desc)

        if (dataChar != null) {
            namaKarakter.text = dataChar.nama
        }
        if (dataChar != null) {
            descKarakter.text = dataChar.deskripsi
        }
        if (dataChar != null) {
            fotoKarakter.setImageResource(dataChar.foto)
        }
    }
    
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_share -> {
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Lihatlah Deskripsi Karakter One Piece ini!!")
                shareIntent.type = "text/plain"
                startActivity(shareIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}