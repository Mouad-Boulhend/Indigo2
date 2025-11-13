package com.example.indigo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class Adapter(private val flights: List<Flight>, val listener: OnItemClickListener) :
    RecyclerView.Adapter<Adapter.FlightCardViewHolder>() {

    inner class FlightCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val airlineName: TextView = itemView.findViewById(R.id.airlineName)
        val departureCode: TextView = itemView.findViewById(R.id.departureCode)
        val departureTime: TextView = itemView.findViewById(R.id.departureTime)
        val arrivalCode: TextView = itemView.findViewById(R.id.arrivalCode)
        val arrivalTime: TextView = itemView.findViewById(R.id.arrivalTime)
        val duration: TextView = itemView.findViewById(R.id.duration)
        val price: TextView = itemView.findViewById(R.id.price)

        fun bind(item: Flight) {
            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightCardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return FlightCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightCardViewHolder, position: Int) {
        val flight = flights[position]
        holder.airlineName.text = flight.airlineName
        holder.departureCode.text = flight.departureCode
        holder.departureTime.text = flight.departureTime
        holder.arrivalCode.text = flight.arrivalCode
        holder.arrivalTime.text = flight.arrivalTime
        holder.duration.text = flight.duration
        holder.price.text = flight.price

        //val bundle = Bundle()
        //bundle.putString("depCode", flight.departureCode)
        //bundle.putString("arrCode", flight.arrivalCode)
        //bundle.putString("duration", flight.duration)
        //bundle.putString("depTime", flight.departureTime)

        holder.bind(flights[position])
    }

    override fun getItemCount(): Int = flights.size
}

interface OnItemClickListener {
    fun onItemClick(item: Flight)
}