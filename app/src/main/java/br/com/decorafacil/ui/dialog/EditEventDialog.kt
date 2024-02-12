package br.com.decorafacil.ui.dialog

import android.content.Context
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import br.com.decorafacil.R
import br.com.decorafacil.models.Event
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class EditEventDialog(private val context: Context) {
    fun show(event: Event) {
        val resources = context.resources
        val drawable =
            ResourcesCompat.getDrawable(resources, R.drawable.dialog_background, null)
        MaterialAlertDialogBuilder(
            context,
            R.style.ThemeOverlay_App_MaterialAlertDialog
        )
            .setTitle(event.client.contractor)
            .setMessage(event.toString())
            .setBackground(drawable)
            .setNeutralButton("Editar") { _, _ ->
                Toast.makeText(
                    context,
                    "Em desenvolvimento",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton("Fechar", null)
            .show()
    }
}