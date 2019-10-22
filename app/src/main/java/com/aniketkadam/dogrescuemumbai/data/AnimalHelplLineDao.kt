package com.aniketkadam.dogrescuemumbai.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

/**
 * Created by Chetan on 2019-10-19.
 */

@Dao
interface AnimalHelplLineDao {

    @Query("SELECT * FROM animal_helpline WHERE id = :id")
    fun getById(id: Int): AnimalHelpLine

    @Query("SELECT * FROM animal_helpline ORDER BY id DESC")
    fun getAll(): LiveData<List<AnimalHelpLine>>

    @Insert(onConflict = REPLACE)
    fun insert(helpLines: List<AnimalHelpLine>)

    @Insert(onConflict = REPLACE)
    fun insert(helpLines: AnimalHelpLine)

}