package com.example.demosc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demosc.databinding.ItemMyBinding

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_my.view.*

class ProductAdapter(
    private val context: Context
) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {


     var data = mutableListOf<Product>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent) as MyViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindProduct(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder private constructor(private val binding: ItemMyBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindProduct(products: Product) {
            val res = itemView.context.resources
            Picasso.get().load(products.imageLogo).into(itemView.logo_image)
            itemView.text_title.text = products.title
            itemView.text_description.text = products.description
            itemView.text_price.text = products.price
        }


        companion object {
            fun from(parent: ViewGroup): RecyclerView.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMyBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

    }

}