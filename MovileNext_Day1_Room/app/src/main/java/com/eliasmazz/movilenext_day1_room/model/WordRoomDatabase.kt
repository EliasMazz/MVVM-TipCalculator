package com.eliasmazz.movilenext_day1_room.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao


    companion object {
        private var instance: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase? {
            if (instance == null) {
                synchronized(WordRoomDatabase::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WordRoomDatabase::class.java,
                        "word_database"
                    ).build()
                }
            }
            return instance!!
        }

    }
}