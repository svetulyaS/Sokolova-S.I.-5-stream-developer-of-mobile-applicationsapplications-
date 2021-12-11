package com.example.sokol.sokolovasiexamexample
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val developerNameTextView: TextView =
        itemView.findViewById(R.id.music_name_text_view)

    fun bind(name: String) {
        developerNameTextView.text = name
    }

}
