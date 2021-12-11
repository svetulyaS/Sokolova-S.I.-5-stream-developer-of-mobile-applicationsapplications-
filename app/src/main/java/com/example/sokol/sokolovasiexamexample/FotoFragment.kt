package com.example.sokol.sokolovasiexamexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment


private const val LAST_ROLLED_IMAGE = "image"

class FotoFragment : Fragment() {

    lateinit var plusButton: Button
    lateinit var galleryImageView: ImageView


    private val galleryImageList: List<Int> = listOf(
        R.drawable.priroda_1,
        R.drawable.priroda_2,
        R.drawable.priroda_3,
        R.drawable.priroda_4,
        R.drawable.priroda_5,
        R.drawable.priroda_6,
    )

    var lastRolledImageRes = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_foto2, container, false)

        galleryImageView = view.findViewById(R.id.gallery_image_view)
        plusButton = view.findViewById(R.id.plus_button)

        if (savedInstanceState != null)
            galleryImageView.setImageResource(savedInstanceState.getInt(LAST_ROLLED_IMAGE))

        plusButton.setOnClickListener {
            lastRolledImageRes = galleryImageList.random()
            galleryImageView.setImageResource(lastRolledImageRes)
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_ROLLED_IMAGE, lastRolledImageRes)
    }

}

