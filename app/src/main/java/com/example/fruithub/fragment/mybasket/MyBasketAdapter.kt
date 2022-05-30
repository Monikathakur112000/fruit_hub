package com.example.fruithub.fragment.mybasket

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fruithub.R
import com.example.fruithub.data.HomeFragmentDataClass
import com.example.fruithub.databinding.MyBasketRecyclerviewBinding
import kotlin.random.Random


class MyBasketAdapter(private val context: Context,
private val dataset: List<HomeFragmentDataClass>
) : RecyclerView.Adapter<MyBasketAdapter.MyBasketViewHolder>() {


    class MyBasketViewHolder(binding: MyBasketRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView = binding.basketImageView
        val textView = binding.myBasketTextView
        val amountTextView = binding.amountTextView
        val cardView  =binding.imageViewConstraint
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBasketViewHolder {
      val binding = MyBasketRecyclerviewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyBasketViewHolder(binding)

    }

    override fun onBindViewHolder(holder:MyBasketViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
        holder.amountTextView.text = context.resources.getString(item.amountResourceId)

        val rnd = Random
        val currentColor = Color.argb(10, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
         //holder.cardView.setCardBackgroundColor(currentColor)
        holder.cardView.setBackgroundColor(currentColor)
        /*val backgroundOff: Drawable = holder.cardView.background //v is a view

        backgroundOff.setTint(currentColor) //defaultColor is an int

        holder.cardView.background = backgroundOff
*/
    }

    override fun getItemCount() = dataset.size



}