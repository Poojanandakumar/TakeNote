package com.note.keepmynote.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.note.keepmynote.R
import com.note.keepmynote.databinding.FragmentHomeBinding
import com.note.keepmynote.ui.note.NoteViewModel
import com.note.shared.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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
            binding.recyclerView.adapter = NotesAdapter(it, requireContext(), homeViewModel)
        })

        homeViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }

        binding.add.setOnClickListener {
            //todo check already existing id and give id to note data
            val action = HomeFragmentDirections.actionHomeFragmentToNoteFragment(
                "",
                "",
                "",
                0
            )
            findNavController().navigate(action)
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
}