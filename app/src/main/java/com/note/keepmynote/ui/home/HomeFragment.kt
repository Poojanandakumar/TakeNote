package com.note.keepmynote.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.note.keepmynote.R
import com.note.keepmynote.databinding.FragmentHomeBinding
import com.note.shared.util.EventObserver

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        homeViewModel.getAllData()
        homeViewModel.data.observe(viewLifecycleOwner, EventObserver {
            val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerView.adapter = HomeNotesAdapter(it, requireContext(), homeViewModel)
        })

        homeViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }

        binding.add.setOnClickListener {
            homeViewModel.getCurrentIdList()
            homeViewModel.currentIdList.observe(viewLifecycleOwner, EventObserver {
                val id = createANewId(it)
                val action = HomeFragmentDirections.actionHomeFragmentToNoteFragment(
                    "",
                    "",
                    "",
                    id
                )
                findNavController().navigate(action)
            })
        }

        homeViewModel.clickedData.observe(viewLifecycleOwner, EventObserver {
            val action = HomeFragmentDirections.actionHomeFragmentToNoteFragment(
                it.title,
                it.note,
                it.color,
                it.id
            )
            findNavController().navigate(action)
        })

        return binding.root
    }


    private fun createANewId(listOfCurrentId: List<Int>): Int {
        var i = 0
        var id = 0
        while (i < listOfCurrentId.size) {
            if (listOfCurrentId.contains(id)) {
                id += 1
                i += 1
            } else {
                break
            }
        }
        return id
    }
}