package io.github.tuguzd.fragments

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import io.github.tuguzd.fragments.databinding.ItemColorBinding

class ColorViewHolder(private val binding: ItemColorBinding) : ViewHolder(binding.root) {
    fun bind(color: String, position: Int): Unit = binding.run {
        colorText.text = color

        val colorValues = binding.root.context.resources.getIntArray(R.array.colorValues)

        colorLayout.setBackgroundColor(colorValues[position])
    }
}
