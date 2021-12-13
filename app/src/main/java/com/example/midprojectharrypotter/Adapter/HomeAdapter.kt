package com.example.midprojectharrypotter.Adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.midprojectharrypotter.DataKarakter
import com.example.midprojectharrypotter.R
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter (private val listKarakter : ArrayList<DataKarakter>):RecyclerView.Adapter<HomeAdapter.HomeHolder>(){
    inner class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(dataKarakter : DataKarakter){
            with(itemView){
                nametv.text = dataKarakter.name
                speciestv.text = "Species : "+dataKarakter.species
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return HomeHolder(view)
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.bind(listKarakter[position])
    }

    override fun getItemCount(): Int = listKarakter.size
}