package com.example.miwok

import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.AudioManager.AUDIOFOCUS_GAIN
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_numbers.*


class NumbersActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        val array = arrayListOf<Word>()                                      /** array list of Word type object it means one index contain two variable miwok and default */
        array.add(Word("one", "lutti",R.drawable.number_one,R.raw.number_one))         /** create an object of "Word" type class pass paratmeter to intilze */
        array.add(Word("Two", "otiiko",R.drawable.number_two,R.raw.number_two))
        array.add(Word("Three", "tolookosu",R.drawable.number_three,R.raw.number_three))
        array.add(Word("four", "oyyisa",R.drawable.number_four,R.raw.number_four))
        array.add(Word("Five", "massokka",R.drawable.number_five,R.raw.number_five))
        array.add(Word("six", "temmokka",R.drawable.number_six,R.raw.number_six))
        array.add(Word("seven", "kenekaku",R.drawable.number_seven,R.raw.number_seven))
        array.add(Word("eight", "kawinta",R.drawable.number_eight,R.raw.number_eight))
        array.add(Word("nine", "wo’e",R.drawable.number_nine,R.raw.number_nine))
        array.add(Word("ten", "na’aacha",R.drawable.number_ten,R.raw.number_ten))


        val listView = findViewById<ListView>(R.id.list)

        listView.adapter = WordAdapter(this,R.layout.list_item,R.color.category_numbers,array)

        list.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            val mItem:Word = array[position]
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


    var audiofocus = AudioManager.OnAudioFocusChangeListener {AUDIOFOCUS_GAIN}

}