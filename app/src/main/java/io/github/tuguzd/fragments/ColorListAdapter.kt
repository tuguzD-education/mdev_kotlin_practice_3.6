package io.github.tuguzd.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import io.github.tuguzd.fragments.databinding.ItemColorBinding

class ColorListAdapter(
    private val colors: List<Pair<String, Int>>,
    private val onItemClicked: (position: Int) -> Unit
) : ListAdapter<String, ColorViewHolder>(ColorDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemColorBinding.inflate(layoutInflater, parent, false)
        return ColorViewHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) =
        holder.bind(colors[position])

    override fun getItemCount(): Int = colors.size
}
