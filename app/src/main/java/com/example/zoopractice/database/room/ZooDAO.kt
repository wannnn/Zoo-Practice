package com.example.zoopractice.database.room

import androidx.room.Insert
import androidx.room.Query
import com.example.zoopractice.model.Results

interface ZooDAO {

    @Query("SELECT * FROM Results")
    fun getZoo(): List<Results>

    @Insert
    fun insertZooData(vararg results: Results)

}