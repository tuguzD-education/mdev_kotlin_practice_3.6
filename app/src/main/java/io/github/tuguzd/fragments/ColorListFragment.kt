package io.github.tuguzd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.tuguzd.fragments.databinding.FragmentColorListBinding

class ColorListFragment : Fragment() {

    private var _binding: FragmentColorListBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: ColorViewModel by activityViewModels()

    private val colors: MutableList<Pair<String, Int>> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentColorListBinding.inflate(inflater, container, false)

        val names = binding.root.context.resources.getStringArray(R.array.colorNames)
        val values = binding.root.context.resources.getIntArray(R.array.colorValues)

        for (index in names.indices)
            colors.add(names[index] to values[index])

        with (binding.root) {
            layoutManager = LinearLayoutManager(context)
            adapter = ColorListAdapter(colors) {
                position -> onListItemClick(position)
            }
        }
        return binding.root
    }

    private fun onListItemClick(position: Int) =
        sharedViewModel.setColor(colors[position].second)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
