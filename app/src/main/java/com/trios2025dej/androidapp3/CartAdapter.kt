package com.trios2025dej.androidapp3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(
    private val items: MutableList<CartItem>,
    private val onCartUpdated: () -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.txtCartName)
        val txtQty: TextView = itemView.findViewById(R.id.txtCartQty)
        val txtPrice: TextView = itemView.findViewById(R.id.txtCartPrice)
        val btnPlus: Button = itemView.findViewById(R.id.btnPlus)
        val btnMinus: Button = itemView.findViewById(R.id.btnMinus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = items[position]

        holder.txtName.text = item.name
        holder.txtQty.text = item.quantity.toString()
        holder.txtPrice.text = "$" + String.format("%.2f", item.price * item.quantity)


        holder.btnPlus.setOnClickListener {
            item.quantity++
            notifyItemChanged(position)
            onCartUpdated()
        }

        holder.btnMinus.setOnClickListener {
            if (item.quantity > 1) {
                item.quantity--
                notifyItemChanged(position)
            } else {
                items.removeAt(position)
                notifyItemRemoved(position)
            }
            onCartUpdated()
        }
    }
}
