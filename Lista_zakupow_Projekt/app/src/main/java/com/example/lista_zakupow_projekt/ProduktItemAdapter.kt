package com.example.lista_zakupow_projekt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_zakupow_projekt.databinding.ProduktItemCellBinding

class ProduktItemAdapter(
    private val produktItem: List<ProduktItem>,
    private val clickListener: ProduktItemClickListener): RecyclerView.Adapter<ProduktItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProduktItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ProduktItemCellBinding.inflate(from, parent, false)
        return ProduktItemViewHolder(parent.context, binding,clickListener)
    }

    override fun onBindViewHolder(holder: ProduktItemViewHolder, position: Int){
       holder.bindProduktItem(produktItem[position])
    }

    override fun getItemCount(): Int = produktItem.size
}