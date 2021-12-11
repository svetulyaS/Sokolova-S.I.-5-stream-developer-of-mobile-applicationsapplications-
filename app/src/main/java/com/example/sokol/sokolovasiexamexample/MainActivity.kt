package com.example.sokol.sokolovasiexamexample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val Hello_KEY = "hello"
private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {

    lateinit var searchImageView: ImageView
    lateinit var bottomNavigationMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)
        bottomNavigationMenu.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null

            when (item.itemId) {

                R.id.music -> {
                    fragment = MusicFragment()
                }
                R.id.gallery -> {
                    fragment = FotoFragment()
                }
            }
            replaceFragment(fragment!!)

            true

        }
        bottomNavigationMenu.selectedItemId = R.id.gallery

        searchImageView = findViewById(R.id.search_image_view)
        searchImageView.setOnClickListener {
            val link = Uri.parse("https://google.com/")
            val intent = Intent(Intent.ACTION_VIEW, link)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationMenu.selectedItemId)

        val currentFragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(
            outState, currentFragment.javaClass.name,
            currentFragment
        )
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(fragment.tag)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}

