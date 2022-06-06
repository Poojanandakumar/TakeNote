package com.note.keepmynote.ui.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.note.keepmynote.R
import com.note.keepmynote.databinding.FragmentHomeBinding
import com.note.keepmynote.databinding.FragmentNoteBinding
import com.note.keepmynote.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

class NoteFragment : Fragment() {
    private val noteViewModel: NoteViewModel by activityViewModels()
    private lateinit var binding: FragmentNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        binding.paleyellow.setOnClickListener {
            binding.noteFragment.setBackgroundResource(R.color.paleyellow)
        }
        binding.paleblue.setOnClickListener {
            binding.noteFragment.setBackgroundResource(R.color.paleblue)
        }
        binding.rose.setOnClickListener {
            binding.noteFragment.setBackgroundResource(R.color.rose)
        }
        binding.palegreen.setOnClickListener {
            binding.noteFragment.setBackgroundResource(R.color.palegreen)
        }
        return binding.root
    }
}