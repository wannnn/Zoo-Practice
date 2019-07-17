package com.example.zoopractice.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zoopractice.model.Results

object ZooDatabase {

    @Database(entities = [Results::class], version = 1)
    abstract class ZooDatabase : RoomDatabase() {
        abstract fun zooDao(): ZooDAO
    }
}