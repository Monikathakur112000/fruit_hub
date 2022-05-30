package com.example.fruithub.fragment.home.adapter


import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fruithub.R
import com.example.fruithub.data.HomeFragmentDataClass
import com.example.fruithub.databinding.HomeScreenTabItemViewBinding
import kotlin.random.Random


class HomeTabAdapter(
    private val context: Context,
    private val dataset: List<HomeFragmentDataClass>
) : RecyclerView.Adapter<HomeTabAdapter.HomeTabViewHolder>() {

    private lateinit var binding: HomeScreenTabItemViewBinding


    class HomeTabViewHolder(binding: HomeScreenTabItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imageView = binding.saladImageView
        val textView = binding.saladTextView
        val amountTextView = binding.amountTextView
        val cardViewBg = binding.tabCardView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTabViewHolder {
        binding = HomeScreenTabItemViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeTabViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeTabViewHolder, position: Int) {
        val item = dataset[position]
         val rnd = Random
        val currentColor = Color.argb(20, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        holder.cardViewBg.setBackgroundColor(currentColor)

        holder.cardViewBg.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeScreenFragment_to_addToBasketFragment)
        )
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
        holder.amountTextView.text = context.resources.getString(item.amountResourceId)


    }

    override fun getItemCount() = dataset.size


}








