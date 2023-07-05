package com.example.lista_zakupow_projekt

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.lista_zakupow_projekt.databinding.FragmentDodajProduktListaBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DodajProduktLista(var ProduktItem: ProduktItem?) : BottomSheetDialogFragment()
{
    private lateinit var binding: FragmentDodajProduktListaBinding
    private lateinit var listaViewModel: ListaViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if(ProduktItem != null){
            binding.prodTitle.text = "Edytuj liste"
            val editable = Editable.Factory.getInstance()
            binding.NazwaProdukt.text = editable.newEditable(ProduktItem!!.nazwa)
            binding.Ilosc.text = editable.newEditable(ProduktItem!!.ilosc)
            binding.Cena.text = editable.newEditable(ProduktItem!!.cena)

        }
        else{
            binding.prodTitle.text = "Nowy produkt"
        }

        listaViewModel = ViewModelProvider(activity).get(ListaViewModel::class.java)
        binding.ZapiszButton.setOnClickListener{
            saveAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDodajProduktListaBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun saveAction() {
        val nazwa = binding.NazwaProdukt.text.toString()
        val ilosc = binding.Ilosc.text.toString()
        val cena = binding.Cena.text.toString()
        if(ProduktItem == null){
            val produktItem = ProduktItem(nazwa, ilosc, cena,null)
            listaViewModel.dodajProdukt(produktItem)
        }
        else{
            ProduktItem!!.nazwa = nazwa
            ProduktItem!!.ilosc = ilosc
            ProduktItem!!.cena = cena
            listaViewModel.aktualizujProdukt(ProduktItem!!)
        }
        binding.NazwaProdukt.setText("")
        binding.Ilosc.setText("")
        binding.Cena.setText("")
        dismiss()
    }
}