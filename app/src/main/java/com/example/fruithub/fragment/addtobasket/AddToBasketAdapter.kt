package com.example.fruithub.fragment.addtobasket

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fruithub.R
import com.example.fruithub.databinding.ListItemViewAddBasketBinding



class AddToBasketAdapter(private val context: Context): RecyclerView.Adapter<AddToBasketAdapter.AddBasketViewHolder>() {


    // Retrieve the list of words from res/values/arrays.xml
    private val words = context.resources.getStringArray(R.array.combo).toList()



    class AddBasketViewHolder(val binding: ListItemViewAddBasketBinding)
        : RecyclerView.ViewHolder(binding.root){
        val button = binding.addBasketItemButton

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddBasketViewHolder {
        val binding = ListItemViewAddBasketBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return AddBasketViewHolder(binding)
    }


    override fun onBindViewHolder(holder: AddBasketViewHolder, position: Int) {
        val item = words[position]
        holder.button.text = item.toString()

    }

    override fun getItemCount(): Int {
        return words.size
    }
}
