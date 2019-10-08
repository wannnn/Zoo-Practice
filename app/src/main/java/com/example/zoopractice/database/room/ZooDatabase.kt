package com.example.zoopractice.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.zoopractice.model.Results

@Database(entities = [Results::class], version = 1)
abstract class ZooDatabase  : RoomDatabase() {

    abstract fun zooDao(): ZooDAO

    companion object {
        private var INSTANCE: ZooDatabase? = null

        fun getInstance(context: Context): ZooDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context, ZooDatabase::class.java, "zooDB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE as ZooDatabase
        }
    }
}