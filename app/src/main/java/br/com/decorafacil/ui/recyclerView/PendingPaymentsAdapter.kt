package br.com.decorafacil.ui.recyclerView

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.decorafacil.databinding.PendingPaymentCardBinding
import br.com.decorafacil.extension.toPtBr
import br.com.decorafacil.models.Payment

class PendingPaymentsAdapter(
    private val context: Context,
    payments: List<Payment>
) : RecyclerView.Adapter<PendingPaymentsAdapter.ViewHolder>() {

    private val payments = payments.toMutableList()

    class ViewHolder(private val binding: PendingPaymentCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val clientName = binding.textViewClientName
        private val paymentValue = binding.textViewPaymentValue

        @SuppressLint("SetTextI18n")
        fun bind(payment: Payment) {
            clientName.text = payment.client.name
            paymentValue.text = payment.value.toPtBr()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PendingPaymentCardBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return payments.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(payments[position])
    }

}