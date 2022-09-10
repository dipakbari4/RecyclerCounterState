package com.dipak.recyclercounterstate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dipak.recyclercounterstate.databinding.ItemProductBinding

class ProductAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size
}

class ProductViewHolder(private val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(product: Product) {
        binding.apply {
            this.productName.text = product.name
            this.productQuantity.text = product.quantity.toString()

            this.btnIncrement.setOnClickListener {
                product.quantity = product.quantity.plus(1)
                this.productQuantity.text = product.quantity.toString()
            }
            this.btnDecrement.setOnClickListener {
                product.quantity = product.quantity.minus(1)
                this.productQuantity.text = product.quantity.minus(1).toString()
            }
        }
    }
}
