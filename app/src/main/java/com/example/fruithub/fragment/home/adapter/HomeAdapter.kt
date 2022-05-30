package com.example.fruithub.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fruithub.R
import com.example.fruithub.databinding.FragmentAddToBasketBinding
import com.example.fruithub.databinding.HomeScreenItemViewBinding

class HomeScreenAdapter(context: Context) :
    RecyclerView.Adapter<HomeScreenAdapter.HomeScreenViewHolder>() {

    // Retrieve the list of words from res/values/arrays.xml
    private val words = context.resources.getStringArray(R.array.recommend).toList()

    class HomeScreenViewHolder(val binding: HomeScreenItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val button = binding.homeScreenButton

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeScreenViewHolder {
        val binding = HomeScreenItemViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeScreenViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HomeScreenViewHolder, position: Int) {
        val item = words[position]
        holder.button.text = item.toString()

    }

    override fun getItemCount(): Int {
        return words.size
    }
}
