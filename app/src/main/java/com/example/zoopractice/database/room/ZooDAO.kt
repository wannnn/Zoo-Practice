package com.example.zoopractice.database.room

import androidx.lifecycle.MutableLiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.zoopractice.model.Results



interface ZooDAO {

    @Insert(onConflict = REPLACE)
    fun insertZooData(results: Results)

    @Query("SELECT * FROM Results WHERE id = :itemId")
    fun getZoo(itemId: String): MutableLiveData<List<Results>>

}