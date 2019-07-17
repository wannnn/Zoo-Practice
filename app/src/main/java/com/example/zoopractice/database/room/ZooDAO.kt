package com.example.zoopractice.database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.zoopractice.model.Results


@Dao
interface ZooDAO {

    @Insert(onConflict = REPLACE)
    fun insertZooData(results: Results)


    @Query("SELECT * FROM Results")
    fun getZoo(): LiveData<List<Results>>

}