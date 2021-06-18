package com.example.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class FamilyActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family)

        val arrayOfFamily = ArrayList<Word>()

        arrayOfFamily.add(Word("father","әpә",R.drawable.family_father,R.raw.family_father))
        arrayOfFamily.add(Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother))
        arrayOfFamily.add(Word("son","angsi",R.drawable.family_son,R.raw.family_son))
        arrayOfFamily.add(Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter))
        arrayOfFamily.add(Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother))
        arrayOfFamily.add(Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother))
        arrayOfFamily.add(Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister))
        arrayOfFamily.add(Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister))
        arrayOfFamily.add(Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother))
        arrayOfFamily.add(Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather))


        val familyList = findViewById<ListView>(R.id.familyList)

        familyList.adapter = WordAdapter(this,R.layout.list_item,R.color.category_family ,arrayOfFamily)

        familyList.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            val mItem:Word = arrayOfFamily[position]
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
