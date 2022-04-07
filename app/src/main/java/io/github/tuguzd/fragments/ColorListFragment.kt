package io.github.tuguzd.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.tuguzd.fragments.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ColorListFragment : Fragment() {

//    private val mValues: Array<String> =
//        arrayOf("package", "as", "typealias", "class", "this", "super", "val", "var", "fun", "for",
//            "null", "true", "false", "is", "in", "throw", "return", "break", "continue", "object",
//            "if", "try", "else", "while", "do", "when", "interface", "yield", "typeof")
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val adapter = ArrayAdapter(
//            activity as Context, R.layout.simple_list_item_1, mValues
//        )
//        listAdapter = adapter
//    }
//
//    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//        TODO("Not yet implemented")
//    }

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        arguments?.getString("word")?.let {
//            word = it
//        }

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_color_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
//                adapter = ColorRecyclerViewAdapter(listener)
                adapter = ColorRecyclerViewAdapter(PlaceholderContent.ITEMS)
            }
        }
        return view
    }

    companion object {
//        @JvmStatic
//        fun newInstance(word: String) =
//            ColorListFragment().apply {
//                arguments = Bundle().apply {
//                    putString("word", word)
//                }
//            }

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ColorListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
