package com.note.keepmynote.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.note.keepmynote.R
import com.note.model.NoteData

class NotesAdapter(private val mList: List<NoteData>, val context: Context) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notes, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.title.text = item.title
        holder.note.text = item.note
        when (item.color) {
            "1" -> {
                holder.cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.paleyellow
                    )
                )
            }
            "2" -> {
                holder.cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.paleblue
                    )
                )
            }
            "3" -> {
                holder.cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.rose
                    )
                )
            }
            "4" -> {
                holder.cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.palegreen
                    )
                )
            }
            "0" -> {
                holder.cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.paleOrange
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val note: TextView = itemView.findViewById(R.id.note)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }
}