package com.trios2025dej.androidapp3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private val items: List<MenuItem>,
    private val onAddToCart: (MenuItem) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgItem: ImageView = itemView.findViewById(R.id.imgItem)
        val txtName: TextView = itemView.findViewById(R.id.txtName)        // ✅ FIXED
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)      // ✅ FIXED
        val btnAdd: Button = itemView.findViewById(R.id.btnAdd)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = items[position]

        holder.imgItem.setImageResource(item.imageRes)
        holder.txtName.text = item.name
        holder.txtPrice.text = "$${item.price}"

        holder.btnAdd.setOnClickListener {
            onAddToCart(item)
        }
    }

    override fun getItemCount(): Int = items.size
}
