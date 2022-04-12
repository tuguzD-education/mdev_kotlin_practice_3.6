package io.github.tuguzd.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import io.github.tuguzd.fragments.databinding.ItemColorBinding

class ColorListAdapter(private val values: List<String>)
    : ListAdapter<String, ColorViewHolder>(ColorDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemColorBinding.inflate(layoutInflater, parent, false)
        return ColorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(values[position], position)
    }

    override fun getItemCount(): Int = values.size
}
