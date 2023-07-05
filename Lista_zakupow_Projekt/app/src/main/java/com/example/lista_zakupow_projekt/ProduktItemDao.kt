package com.example.lista_zakupow_projekt

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ProduktItemDao {
    @Query("SELECT * FROM produkt_item_table ORDER BY id ASC")
    fun allProduktItems(): Flow<List<ProduktItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduktItem(produktItem: ProduktItem)

    @Update
    suspend fun updateProduktItem(produktItem: ProduktItem)

    @Delete
    suspend fun deleteProduktItem(produktItem: ProduktItem)
}