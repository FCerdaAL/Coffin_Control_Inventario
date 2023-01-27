package com.hfad.coffincontrolinventario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.hfad.coffincontrolinventario.databinding.FragmentPVStockBinding
import com.hfad.coffincontrolinventario.databinding.FragmentPuntosVentaBinding




class PVStockFragment : Fragment() {

    // Colocar el binding object correcto!!

    private var _binding: FragmentPVStockBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPVStockBinding.inflate(inflater, container, false)

        val view = binding.root
        return view
    }

    val args: PVStockFragmentArgs by navArgs() // Se coloca el nombre de la clase que recibe el argumento


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //val tv = view.findViewById<TextView>(R.id.dinamico)
        val amount = args.puntoVenta // Es la variable que se creo en el nav graph para el destination Fragment
        //
       binding.dinamico.text = amount.toString()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}