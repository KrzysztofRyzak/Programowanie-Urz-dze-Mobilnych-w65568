package com.example.lista_zakupow_projekt

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity (tableName = "produkt_item_table")
class ProduktItem(
   @ColumnInfo(name = "nazwa") var nazwa: String,
   @ColumnInfo(name = "ilosc")var ilosc: String,
   @ColumnInfo(name = "cena")var cena: String,
   @ColumnInfo(name = "completedDateString")var completedDateString: String?,
   @PrimaryKey(autoGenerate = true)var id: Int = 0
)