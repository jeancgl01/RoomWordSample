package com.mtw.juancarlos.roomwordsample.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity (tableName = "word_table")
data class Word (
        @PrimaryKey
        @ColumnInfo(name = "word")
        @NonNull
        var mWord:String
)