package com.note.keepmynote.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.note.keepmynote.R
import com.note.keepmynote.databinding.FragmentNoteBinding


class NoteFragment : Fragment() {
    private val noteViewModel: NoteViewModel by activityViewModels()
    private lateinit var binding: FragmentNoteBinding

    private var colorIs:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        binding.paleyellow.setOnClickListener {
            binding.noteFragment.setBackgroundResource(R.color.paleyellow)
            binding.titleCardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.paleyellow
                )
            )
            binding.cardViewEditNote.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.paleyellow
                )
            )

            colorIs = R.color.paleyellow
        }
        binding.paleblue.setOnClickListener {
            binding.noteFragment.setBackgroundResource(R.color.paleblue)
            binding.titleCardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.paleblue
                )
            )
            binding.cardViewEditNote.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.paleblue
                )
            )
            colorIs = R.color.paleblue
        }
        binding.rose.setOnClickListener {
            binding.noteFragment.setBackgroundResource(R.color.rose)
            binding.titleCardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.rose
                )
            )
            binding.cardViewEditNote.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.rose
                )
            )
            colorIs = R.color.rose
        }
        binding.palegreen.setOnClickListener {
            binding.noteFragment.setBackgroundResource(R.color.palegreen)
            binding.titleCardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.palegreen
                )
            )
            binding.cardViewEditNote.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.palegreen
                )
            )
            colorIs = R.color.palegreen
        }

        val title = binding.titleEdit.text.toString()
        val note = binding.noteEdit.text.toString()

        binding.save.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }
}