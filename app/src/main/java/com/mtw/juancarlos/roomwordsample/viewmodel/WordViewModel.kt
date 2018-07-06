package com.mtw.juancarlos.roomwordsample.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.mtw.juancarlos.roomwordsample.WordRepository
import com.mtw.juancarlos.roomwordsample.db.Word

class WordViewModel (application: Application) : AndroidViewModel (application) {

    private val mRepository = WordRepository (application)
    private val mAllWords = mRepository.getAllWords()

    fun getAllWords(): LiveData<List<Word>> = mAllWords

    fun insert(word:Word){
        mRepository.insertWord(word)
    }


}