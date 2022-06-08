package com.note.keepmynote.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.note.keepmynote.R
import com.note.keepmynote.databinding.FragmentNoteBinding
import com.note.model.NoteData
import com.note.shared.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class NoteFragment : Fragment() {
    private val noteViewModel: NoteViewModel by activityViewModels()
    private lateinit var binding: FragmentNoteBinding

    private var colorIs = "0"
    private val args:NoteFragmentArgs by navArgs()

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

            colorIs = "1"
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
            colorIs = "2"
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
            colorIs = "3"
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
            colorIs = "4"
        }

        binding.save.setOnClickListener {
            noteViewModel.addNoteData(
                NoteData(
                    binding.titleEdit.text.toString(),
                    binding.noteEdit.text.toString(),
                    colorIs,args.id
                )
            )
        }

        noteViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }

        noteViewModel.added.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigateUp()
        })

            binding.titleEdit.setText(args.title)
            binding.noteEdit.setText(args.note)
            binding.cardViewEditNote.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.paleOrange
                )
            )
            binding.titleCardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.paleOrange
                )
            )
        return binding.root
    }
}