package com.example.projekakhir

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projekakhir.databinding.ItemRowMakananBinding

class ListFoodAdapter (private val listFood: ArrayList<Makanan>) : RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemRowMakananBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup : ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowMakananBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listFood.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listFood[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItem)
        holder.binding.tvFoodName.text = name
        holder.binding.description.text = description
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                putExtra("key_makanan", listFood[position])
            }

            holder.itemView.context.startActivity(intentDetail)
        }
    }
}
