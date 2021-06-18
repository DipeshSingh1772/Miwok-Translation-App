package com.example.miwok

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class WordAdapter(private var mcontext:Context, private var resource: Int, private var _diffColor:Int, private var listItem:List<Word>) : ArrayAdapter<Word>(mcontext, resource, _diffColor ,listItem) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val enflater:LayoutInflater = LayoutInflater.from(mcontext)     /** layout inflator convert xml file to views object */
        val listView:View = enflater.inflate(resource,null)

        val mMiwok:TextView = listView.findViewById(R.id.miwok_text_view)   /**from list_item.xml file*/
        val mDefault:TextView = listView.findViewById(R.id.default_text_view)   /**from list_item.xml file*/
        val mImageLink:ImageView = listView.findViewById(R.id.imageLink)
        val subLinearLayout: View = listView.findViewById(R.id.subLinearLayout)
        val mItem:Word = listItem[position] /** current postion of screen */

        mMiwok.text = mItem.mMiwokTranslation /** set text in Word.kt file variable*/
        mDefault.text = mItem.mDefaultTranslation   /** set text in Word.kt file variable*/
        subLinearLayout.setBackgroundColor(_diffColor)

//        var mediaCont:MediaPlayer = MediaPlayer.create(mcontext, mItem.mAudioLink)

//        subLinearLayout.setOnClickListener {
//
//            mediaCont = MediaPlayer.create(mcontext, mItem.mAudioLink)
//
//            if (mediaCont.isPlaying)
//                mediaCont.pause()
//            else {
//                mediaCont.start()
//            }
//        }
//
//         mediaCont.setOnCompletionListener {
//            mediaCont.release()
//        }



        if (mItem.mImageLink!=0)
            mImageLink.setImageResource(mItem.mImageLink)
        else
            mImageLink.visibility = View.GONE


        return listView
    }
}