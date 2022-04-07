package io.github.tuguzd.fragments

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import io.github.tuguzd.fragments.placeholder.PlaceholderContent.PlaceholderItem
import io.github.tuguzd.fragments.databinding.FragmentColorBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class ColorRecyclerViewAdapter(
    private val values: List<PlaceholderItem>,
//    private val mValues: List<String> =
//        listOf("package", "as", "typealias", "class", "this", "super", "val", "var", "fun", "for",
//            "null", "true", "false", "is", "in", "throw", "return", "break", "continue", "object",
//            "if", "try", "else", "while", "do", "when", "interface", "yield", "typeof")
) : RecyclerView.Adapter<ColorRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentColorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = mValues[position]
//        holder.contentView.text = item
//
//        with(holder.contentView) {
//            tag = item
////            setOnClickListener(mOnClickListener)
//        }

        val item = values[position]
        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int =
//        mValues.size
        values.size

    inner class ViewHolder(binding: FragmentColorBinding) : RecyclerView.ViewHolder(binding.root) {
        val contentView: TextView = binding.content

        override fun toString(): String {
            return contentView.text.toString()
        }
    }
}
