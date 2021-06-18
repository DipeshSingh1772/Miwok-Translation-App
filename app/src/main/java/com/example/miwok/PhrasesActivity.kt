package com.example.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PhrasesActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phrases)



        val arrayOfPhrases = ArrayList<Word>()

        arrayOfPhrases.add(Word("Where are you going ?","minto wuksus",R.raw.phrase_where_are_you_going))
        arrayOfPhrases.add(Word("What is Your Name ?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name))
        arrayOfPhrases.add(Word("My name is..","oyaaset..",R.raw.phrase_my_name_is))
        arrayOfPhrases.add(Word("How are you feeling?","michәksәs ?",R.raw.phrase_how_are_you_feeling))
        arrayOfPhrases.add(Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good))
        arrayOfPhrases.add(Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming))
        arrayOfPhrases.add(Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming))
        arrayOfPhrases.add(Word("I’m coming.","әәnәm",R.raw.phrase_im_coming))
        arrayOfPhrases.add(Word("Let’s go.","yoowutis",R.raw.phrase_lets_go))
        arrayOfPhrases.add(Word("Come here.","әnni'nem",R.raw.phrase_come_here))


        val phrasesList = findViewById<ListView>(R.id.phrasesList)

        phrasesList.adapter = WordAdapter(this,R.layout.list_item,R.color.category_phrases,arrayOfPhrases)

        phrasesList.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            val mItem:Word = arrayOfPhrases[position]
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