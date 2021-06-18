package com.example.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_colors.*

class ColorsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)

        val arrayOfColor = ArrayList<Word>()

        arrayOfColor.add(Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red))
        arrayOfColor.add(Word("green","chokokki",R.drawable.color_green,R.raw.color_green))
        arrayOfColor.add(Word("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown))
        arrayOfColor.add(Word("grey","ṭopoppi",R.drawable.color_gray,R.raw.color_gray))
        arrayOfColor.add(Word("black","kululli",R.drawable.color_black,R.raw.color_black))
        arrayOfColor.add(Word("white","kelelli",R.drawable.color_white,R.raw.color_white))
        arrayOfColor.add(Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow))
        arrayOfColor.add(Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow))


        val colorView = findViewById<ListView>(R.id.colorList)

        colorView.adapter = WordAdapter(this,R.layout.list_item,R.color.category_colors ,arrayOfColor)

        colorList.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            val mItem:Word = arrayOfColor[position]
            var mMediaPlayer = MediaPlayer.create(this,mItem.getAudio())
            mediacontrol = mMediaPlayer
            
                mMediaPlayer.start()

        })

    }

    var mediacontrol:MediaPlayer? = null

    fun releaseMediaPlayer(){
        if(mediacontrol!=null) {
            mediacontrol?.release()
        }

    }

    override fun onStop() {
        super.onStop()
        releaseMediaPlayer()
    }
}