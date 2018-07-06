package com.mtw.juancarlos.roomwordsample

import android.app.Application
import android.arch.lifecycle.LiveData
import com.mtw.juancarlos.roomwordsample.db.Word
import com.mtw.juancarlos.roomwordsample.db.WordRoomDatabase
import com.mtw.juancarlos.roomwordsample.helpers.doAsync

class WordRepository (val application: Application) {


    private val mWordDao = WordRoomDatabase.getDatabase(application)!!.wordDao()
    private val mAllWords = mWordDao.getAllWords()

    fun getAllWords():LiveData<List<Word>> = mAllWords


    fun insertWord(word:Word) {
        doAsync {
            mWordDao.insert(word)
        }.execute()
    }

}