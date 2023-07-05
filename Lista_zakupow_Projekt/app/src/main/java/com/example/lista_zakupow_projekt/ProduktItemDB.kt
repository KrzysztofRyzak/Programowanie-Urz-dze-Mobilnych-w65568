package com.example.lista_zakupow_projekt

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProduktItem::class], version = 1, exportSchema = false)
abstract class ProduktItemDB: RoomDatabase(){
    abstract fun produktItemDao(): ProduktItemDao

    companion object{
        @Volatile
        private var INSTANCE: ProduktItemDB? = null


        fun getDatabase(context: Context): ProduktItemDB {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProduktItemDB::class.java,
                    "produkt_item_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
