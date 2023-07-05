package com.example.lista_zakupow_projekt

import android.app.Application

class ListaZakupowApp: Application() {
    private val db by lazy {ProduktItemDB.getDatabase(this)}
    val repository by lazy {ProduktItemRepository(db.produktItemDao())}
}