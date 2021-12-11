package com.example.sokol.sokolovasiexamexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MusicFragment : Fragment() {

    lateinit var musicRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_music, container, false)

        val musicNames: List<String> = listOf("Classical music", "Folk music", "Spiritual music", "Latin American music", "Blues", "Rhythm and blues", "Jazz", "Chanson", "Romance")


        musicRecyclerView = view.findViewById(R.id.music_recycler_view)
        musicRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        musicRecyclerView.adapter = MusicAdapter(musicNames)


        return view
    }


}