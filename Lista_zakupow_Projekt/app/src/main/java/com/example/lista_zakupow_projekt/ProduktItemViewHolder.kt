package com.example.lista_zakupow_projekt

import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_zakupow_projekt.databinding.ProduktItemCellBinding

class ProduktItemViewHolder(
    private val context: Context,
    private val binding: ProduktItemCellBinding,
    private val clickListener: ProduktItemClickListener): RecyclerView.ViewHolder(binding.root){
    fun bindProduktItem(produktItem: ProduktItem){
        binding.nazwa.text = produktItem.nazwa

        binding.produktCellContainer.setOnClickListener{
            clickListener.editProduktItem(produktItem)
        }
        binding.deleteButton.setOnClickListener{
            clickListener.deleteProduktItem(produktItem)
        }
    }
}