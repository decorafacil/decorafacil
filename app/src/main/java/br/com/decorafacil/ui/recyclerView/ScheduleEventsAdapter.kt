package br.com.decorafacil.ui.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.decorafacil.databinding.EventCardBinding
import br.com.decorafacil.extensions.toPtBr
import br.com.decorafacil.models.Event
import br.com.decorafacil.ui.dialog.EditEventDialog

class ScheduleEventsAdapter(
    private val context: Context,
    events: List<Event>
) : RecyclerView.Adapter<ScheduleEventsAdapter.ViewHolder>() {

    private val events = events.toMutableList()

    class ViewHolder(private val binding: EventCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val eventDayOfMonth = binding.textViewEventDayOfMonth
        private val eventMonth = binding.textViewEventMonth
        private val clientName = binding.textViewClientName
        private val eventAddress = binding.textViewEventAddress
        private val eventTimetable = binding.textViewEventTimetable

        fun bind(event: Event) {
            eventDayOfMonth.text = event.timetable.date.dayOfMonth.toString()
            eventMonth.text = event.timetable.date.month.toPtBr().substring(0, 3)
            clientName.text = event.client.contractor
            eventAddress.text = event.address.toString()
            eventTimetable.text = "${event.timetable.startTime} - ${event.timetable.endTime}"
        }

        fun onClick(event: Event) {
            binding.root.setOnClickListener {
                val editEventDialog = EditEventDialog(binding.root.context)
                editEventDialog.show(event)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EventCardBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(events[position])
        holder.onClick(events[position])
    }

}