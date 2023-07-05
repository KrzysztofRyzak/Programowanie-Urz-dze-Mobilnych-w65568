package com.example.lista_zakupow_projekt
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ProduktItemRepository(private val produktItemDao: ProduktItemDao){
    val allProduktItems: Flow<List<ProduktItem>> = produktItemDao.allProduktItems()

    @WorkerThread
    suspend fun insertProduktItem(produktItem: ProduktItem){
        produktItemDao.insertProduktItem(produktItem)
    }

    @WorkerThread
    suspend fun updateProduktItem(produktItem: ProduktItem){
        produktItemDao.updateProduktItem(produktItem)
    }

    @WorkerThread
    suspend fun deleteProduktItem(produktItem: ProduktItem){
        produktItemDao.deleteProduktItem(produktItem)
    }
}