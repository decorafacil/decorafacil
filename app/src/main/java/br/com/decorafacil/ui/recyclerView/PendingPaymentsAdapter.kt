package br.com.decorafacil.ui.recyclerView

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.decorafacil.databinding.PendingPaymentCardBinding
import br.com.decorafacil.extension.toPtBr
import br.com.decorafacil.ui.recyclerView.model.HiddenOrVisibleEvent

class PendingPaymentsAdapter(
    private val context: Context,
    events: List<HiddenOrVisibleEvent>,
) : RecyclerView.Adapter<PendingPaymentsAdapter.ViewHolder>() {

    private val events = events.toMutableList()

    class ViewHolder(private val binding: PendingPaymentCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val clientName = binding.textViewClientName
        private val paymentValue = binding.textViewPaymentValue

        @SuppressLint("SetTextI18n")
        fun bind(hiddenOrVisibleEvent: HiddenOrVisibleEvent) {
            clientName.text = hiddenOrVisibleEvent.event.client.contractor
            paymentValue.text =
                if (hiddenOrVisibleEvent.visible) hiddenOrVisibleEvent.event.payment.value.toPtBr() else "R$ ******"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PendingPaymentCardBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(events[position])
    }

}