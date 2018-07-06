package com.mtw.juancarlos.roomwordsample.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database (entities = [Word::class],version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase () {

    companion object {
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(WordRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        // Create database here
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                WordRoomDatabase::class.java,
                                "word_database.db").build()
                    }
                }
            }
            return INSTANCE
        }
    }


    abstract fun wordDao():WordDao

}