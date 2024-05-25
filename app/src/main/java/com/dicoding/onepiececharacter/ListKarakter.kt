package com.dicoding.onepiececharacter

import android.content.Intent
import android.media.browse.MediaBrowser.ItemCallback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListKarakter(private val listData: ArrayList<Character> ) : RecyclerView.Adapter<ListKarakter.ListView>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallBack
    }

    class ListView(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgPhoto: ImageView = itemView.findViewById(R.id.foto_card)
        val charName: TextView = itemView.findViewById(R.id.nama_karakter)
        val charDesc: TextView = itemView.findViewById(R.id.deskripsi_karakter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListView {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return ListView(view)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ListView, position: Int) {
        val (nama, deskripsi, foto) = listData[position]
        holder.imgPhoto.setImageResource(foto)
        holder.charName.text = nama
        holder.charDesc.text = deskripsi
        holder.itemView.setOnClickListener {
            val intentPindah = Intent(holder.itemView.context, DeskripsiChar::class.java)
            intentPindah.putExtra("char", listData[holder.adapterPosition])
            holder.itemView.context.startActivity(intentPindah)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Character)
    }

}