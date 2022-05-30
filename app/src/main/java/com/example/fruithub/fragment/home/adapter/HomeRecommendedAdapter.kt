package com.example.fruithub.fragment.home.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fruithub.R
import com.example.fruithub.data.HomeFragmentDataClass
import com.example.fruithub.databinding.HomeScreenRecommendItemViewBinding


class HomeRecommendedAdapter(
    private val context: Context,
    private val dataset: List<HomeFragmentDataClass>
) : RecyclerView.Adapter<HomeRecommendedAdapter.HomeRecommendedViewHolder>() {


    private lateinit var binding: HomeScreenRecommendItemViewBinding

    class HomeRecommendedViewHolder(binding: HomeScreenRecommendItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imageView = binding.saladImageView
        val textView = binding.saladTextView
        val amountTextView = binding.amountTextView
        val cardView = binding.recommendCardView


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecommendedViewHolder {
        binding = HomeScreenRecommendItemViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeRecommendedViewHolder(binding)

    }

    override fun onBindViewHolder(holder: HomeRecommendedViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
        holder.amountTextView.text = context.resources.getString(item.amountResourceId)
        holder.cardView.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeScreenFragment_to_addToBasketFragment)

        )
    }

    override fun getItemCount() = dataset.size

}




