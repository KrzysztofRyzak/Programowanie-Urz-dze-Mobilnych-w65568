package com.example.lista_zakupow_projekt

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lista_zakupow_projekt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ProduktItemClickListener
{
    private lateinit var binding: ActivityMainBinding
    private val listaViewModel: ListaViewModel by viewModels{
        ProduktItemModelFactory((application as ListaZakupowApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ProduktDodajButton.setOnClickListener {
            DodajProduktLista(null).show(supportFragmentManager, "NowyProduktTag")
        }
        setRecyclerView()
    }

    private fun setRecyclerView(){
        val mainActivity = this
        listaViewModel.produktItems.observe(this){
            binding.ListaRecycleView.apply{
                layoutManager= LinearLayoutManager(applicationContext)
                adapter = ProduktItemAdapter(it, mainActivity)
            }
        }
    }

    override fun editProduktItem(produktItem: ProduktItem){
        DodajProduktLista(produktItem).show(supportFragmentManager, "NowyProduktTag")
    }

    override fun deleteProduktItem(produktItem: ProduktItem){
       listaViewModel.usunProduktItem(produktItem)
    }
}