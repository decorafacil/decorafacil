package br.com.decorafacil.ui.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.decorafacil.databinding.ServiceItemBinding
import br.com.decorafacil.extensions.toPtBr
import br.com.decorafacil.models.Service

class EventServicesAdapter(
    private val context: Context,
    services: List<Service> = mutableListOf()
) : RecyclerView.Adapter<EventServicesAdapter.ViewHolder>() {

    private val services = services.toMutableList()

    class ViewHolder(binding: ServiceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val description = binding.textViewDescription
        private val value = binding.textViewValue

        fun bind(service: Service) {
            description.text = service.description
            value.text = service.value.toPtBr()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ServiceItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return services.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(services[position])
    }

    fun addItem(service: Service) {
        services.add(0, service)
        notifyItemInserted(0)
    }

    fun getServices(): List<Service> {
        return services.toList()
    }

}