package com.dhruv.pokemon_dhruv.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import com.dhruv.pokemon_dhruv.R
import dagger.hilt.android.AndroidEntryPoint
import java.lang.String

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //temp code for getting dominant color for detail screen
        val bmp = BitmapFactory.decodeResource(this.resources,R.drawable.avatar).copy(Bitmap.Config.ARGB_8888,true)

        Palette.from(bmp).generate{
            it?.dominantSwatch?.rgb.let {
                Log.d("color", String.format("#%06X", 0xFFFFFF and it!!))
            }

        }
    }
}