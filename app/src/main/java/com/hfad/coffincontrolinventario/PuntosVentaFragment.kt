package com.hfad.coffincontrolinventario

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginTop
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hfad.coffincontrolinventario.ViewModel.PuntosVentaViewModel
import com.hfad.coffincontrolinventario.databinding.FragmentPuntosVentaBinding
import com.hfad.coffincontrolinventario.ui.components.NombreDialog


class PuntosVentaFragment : Fragment() {


    private var _binding: FragmentPuntosVentaBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!



    /*// Importando viewmodel
    val viewmodel = ViewModelProvider(this).get(PuntosVentaViewModel::class.java)*/

    lateinit var viewmodel : PuntosVentaViewModel


    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPuntosVentaBinding.inflate(inflater, container, false)

        // Importando viewmodel
        viewmodel = ViewModelProvider(this).get(PuntosVentaViewModel::class.java)



        for (item in viewmodel.list){
            binding.linearLayout.addView(item)
        }



        val view = binding.root

       // binding.fabMain.setOnClickListener {
            //Toast.makeText(activity,"Añadir puntos de venta", Toast.LENGTH_SHORT).show()
        //    createAndAddView(view)
      //  }

        // Se crean las vistas almacenadas en la lista mutable que contendrá
        // elementos de tipo Button




        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)

        /*binding.linearLayout.removeView(view)
        for (item in viewmodel.list){
            binding.linearLayout.addView(item)

        }*/

        binding.fabMain.setOnClickListener {
            NombreDialog(
                onSubmitClickListener = {
                    //Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    createAndAddView( it)
                }
            ).show(parentFragmentManager, "dialog")



        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    //var vistas : MutableList<View> = mutableListOf(Button(activity))

    fun createAndAddView( text : String){



        val newElement = Button(activity)

        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)

        newElement.layoutParams = params
        newElement.text = text


        // Apendeando vistas al linear layout
        binding.linearLayout.addView(newElement)

        // Guardando los views creados de manera dinamica en el ViewModel
        viewmodel.list.add(newElement)



        // Asignando un setOnClickListener
        newElement.setOnClickListener{


            val amount = newElement.text.toString()


            val action = PuntosVentaFragmentDirections.actionPuntosVentaFragmentToPVStockFragment(amount)
            findNavController().navigate(action)

        }/*
        // Asignando un setOnClickListener
        newElement.setOnClickListener(View.OnClickListener {


            val amount = newElement.text.toString()


            val action = PuntosVentaFragmentDirections.actionPuntosVentaFragmentToPVStockFragment(amount)
            findNavController().navigate(action)

        })*/




    }





}