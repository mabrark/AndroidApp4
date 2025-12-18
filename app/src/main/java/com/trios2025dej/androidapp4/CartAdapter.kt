package com.trios2025dej.androidapp4

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trios2025dej.androidapp4.databinding.ItemMenuBinding
import com.trios2025dej.androidapp4.models.MenuItem


class CartAdapter(
    private val items: MutableList<MenuItem>,
    private val onUpdate: () -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemMenuBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.binding.txtName.text = item.name
        holder.binding.txtPrice.text = "$%.2f".format(item.price)
        holder.binding.imgItem.setImageResource(item.imageResId)


        holder.binding.btnFavorite.text = "Remove"
        holder.binding.btnFavorite.setOnClickListener {
            items.removeAt(position)
            notifyItemRemoved(position)
            onUpdate()
        }
    }

    override fun getItemCount(): Int = items.size
}
