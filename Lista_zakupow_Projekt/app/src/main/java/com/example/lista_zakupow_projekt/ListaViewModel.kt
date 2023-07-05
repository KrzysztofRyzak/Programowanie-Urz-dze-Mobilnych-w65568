package com.example.lista_zakupow_projekt

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.UUID

class ListaViewModel(private val repository: ProduktItemRepository): ViewModel() {
     var produktItems: LiveData<List<ProduktItem>> = repository.allProduktItems.asLiveData()


     fun dodajProdukt(produktItem: ProduktItem) = viewModelScope.launch{
        repository.insertProduktItem(produktItem)
     }

     fun aktualizujProdukt(produktItem: ProduktItem) = viewModelScope.launch {
        repository.updateProduktItem(produktItem)
     }

    fun usunProduktItem(produktItem: ProduktItem) = viewModelScope.launch {
        repository.deleteProduktItem(produktItem)
    }
}

class ProduktItemModelFactory(private val repository: ProduktItemRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListaViewModel::class.java))
            return ListaViewModel(repository) as T
        throw IllegalArgumentException("Błąd klasy")
    }
}