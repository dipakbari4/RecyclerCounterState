package com.dipak.recyclercounterstate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.dipak.recyclercounterstate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val products = mutableListOf<Product>()

        for (index in 1..100) {
            products.add(Product("Product #$index", index, 5))
        }

        val productAdapter = ProductAdapter(products)
        binding.recyclerView.adapter = productAdapter
    }
}