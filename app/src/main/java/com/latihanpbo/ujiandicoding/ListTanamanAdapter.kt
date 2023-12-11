package com.latihanpbo.ujiandicoding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListTanamanAdapter(
    private val listtanaman : ArrayList<Tanaman>,
    private val onClick: (Tanaman) -> Unit)
    : RecyclerView.Adapter<ListTanamanAdapter.ListViewHolder>(){


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView = itemView.findViewById(R.id.img_tanaman)
        val tvName : TextView = itemView.findViewById(R.id.tv_nama_tanaman)
        var tvDescription : TextView = itemView.findViewById(R.id.tv_desc_pahlawan)
        fun bind(tanaman: Tanaman) {
            itemView.setOnClickListener {
                onClick(tanaman)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_tanaman, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listtanaman.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listtanaman[position]
        val tanaman = listtanaman[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.bind(tanaman)
    }

}