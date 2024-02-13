package br.com.decorafacil.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import br.com.decorafacil.R
import br.com.decorafacil.models.Event

class EditEventDialog(private val context: Context) {

    private val inflater = LayoutInflater.from(context)
    private val view = inflater.inflate(R.layout.event_custom_dialog, null)
    private val textViewClientName = view.findViewById<TextView>(R.id.textViewClientName)
    private val textViewEventAddress = view.findViewById<TextView>(R.id.textViewEventAddress)
    private val textViewBirthdayPersonName =
        view.findViewById<TextView>(R.id.textViewBirthdayPersonName)
    private val buttonEdit = view.findViewById<Button>(R.id.buttonEdit)
    private val buttonCancelEvent = view.findViewById<Button>(R.id.buttonCancelEvent)
    private val buttonBack = view.findViewById<Button>(R.id.buttonBack)
    private val alertDialog = AlertDialog.Builder(context)
        .setCancelable(true)
        .create()

    fun show(event: Event) {
        configComponents(event)
        alertDialog.setView(view)
        alertDialog.show()
    }

    private fun configComponents(event: Event) {
        textViewClientName.text = event.client.contractor
        textViewEventAddress.text = event.address.toString()
        textViewBirthdayPersonName.text = "Aniversariante: ${event.client.birthdayPersonName}"

        buttonEdit.setOnClickListener {
            Toast.makeText(
                context,
                "Em desenvolvimento",
                Toast.LENGTH_SHORT
            ).show()
            alertDialog.dismiss()
        }

        buttonCancelEvent.setOnClickListener {
            Toast.makeText(
                context,
                "Em desenvolvimento",
                Toast.LENGTH_SHORT
            ).show()
            alertDialog.dismiss()
        }

        buttonBack.setOnClickListener {
            alertDialog.dismiss()
        }
    }
}
