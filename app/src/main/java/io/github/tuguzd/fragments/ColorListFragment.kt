package io.github.tuguzd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.tuguzd.fragments.databinding.FragmentColorListBinding

class ColorListFragment : Fragment() {

    private var _binding: FragmentColorListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentColorListBinding.inflate(inflater, container, false)

        val colors = context?.resources?.getStringArray(R.array.colorNames)!!
        val values: MutableList<String> = ArrayList()

        for (color in colors) values.add(color)

        with (binding.root) {
            layoutManager = LinearLayoutManager(context)
            adapter = ColorListAdapter(values)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
