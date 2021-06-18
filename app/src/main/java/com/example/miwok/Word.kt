package com.example.miwok

import android.graphics.Color

class Word(_defaultTranslation:String, _miwokTranslation:String,_maudioLink:Int) {

    var mDefaultTranslation: String = ""
    var mMiwokTranslation: String = ""
    var mImageLink: Int = 0
    var mAudioLink:Int = 0

    constructor(
        _defaultTranslation: String,
        _miwokTranslation: String,
        _imageLink: Int,
        _maudioLink:Int
    ) : this(_defaultTranslation, _miwokTranslation, _maudioLink ){
        mImageLink = _imageLink
    }


        /** in word class parameter is passed this is called
     * constructor in kotlin which is intilize in "init block" */



    init {
        this.mDefaultTranslation = _defaultTranslation      /** here intilization of var by constructor */
        this.mMiwokTranslation = _miwokTranslation
        this.mAudioLink = _maudioLink
    }


    fun getDefaultTranslation(): String{
        return mDefaultTranslation
    }                                                   /** this is getter function by which we can access value in another file  */

    fun getMiwokTranslation():String {
        return mMiwokTranslation
    }

    fun getAudio():Int {
        return mAudioLink
    }

}