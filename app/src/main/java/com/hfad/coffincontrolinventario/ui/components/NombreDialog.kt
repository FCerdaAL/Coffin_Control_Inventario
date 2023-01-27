package com.hfad.coffincontrolinventario.ui.components

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ExpandableListView.OnChildClickListener
import androidx.fragment.app.DialogFragment
import com.hfad.coffincontrolinventario.databinding.DialogInputBinding

class NombreDialog(
    private val onSubmitClickListener: (String) -> Unit
) : DialogFragment() {

    private lateinit var binding : DialogInputBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = DialogInputBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.bAgregarPuntoVenta.setOnClickListener {
            onSubmitClickListener.invoke(binding.etPuntoDeVenta.text.toString())
            dismiss() // Muy importanteeee
        }

        binding.bCancelar.setOnClickListener {
            dismiss()
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog



    }
}