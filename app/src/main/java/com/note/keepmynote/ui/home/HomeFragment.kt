package com.note.keepmynote.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.note.keepmynote.R
import com.note.keepmynote.databinding.FragmentHomeBinding
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

        val data = mutableListOf(
            NotesData("pooja", "hi i am pooja flkjflksadjfkjdsak j jfkladsjlkf s" +
                    "af jklfjsadkfj ksd fjdskfj sldkjf sdklf  jfksdjf kjsd klfjskd fjskdlfjksldjf " +
                    "ksdj fksdjdskf jdskl j lksdfj fhdsjfjsdfkjhsdkjfhkdsjhfjdshfkjdhfjkhdjf " +
                    "sdkfjkdsjfkjdskfjdksjfkjdsf" +
                    "fksdjfkldsjfkljdsfkjsdkfjdskljf" +
                    "kjflksdjflksdjfjfkldsjfkljdsklf"),
            NotesData("sreelesh", "hi i am sreelesh"),
            NotesData("krishna shankar", "hi i am sankar")
        )

        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = NotesAdapter(data)

        binding.add.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_noteFragment)
        }
        return binding.root
    }
}