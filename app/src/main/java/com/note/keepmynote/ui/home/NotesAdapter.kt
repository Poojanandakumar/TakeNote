package com.note.keepmynote.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.note.keepmynote.R

class NotesAdapter(private val mList: List<NotesData>) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notes, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val item = mList[position]
        holder.title.text = item.title
        holder.note.text = item.note
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val note: TextView = itemView.findViewById(R.id.note)
    }
}