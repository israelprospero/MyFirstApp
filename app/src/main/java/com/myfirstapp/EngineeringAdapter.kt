package com.myfirstapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class EngineeringAdapter(
    private val data: ArrayList<Engineering>, // this is like a global variable
) : RecyclerView.Adapter<EngineeringAdapter.EngineeringViewHolder>() {

    // SoccerTeamsViewHolder inherits from RecyclerView
    // ViewHolder is a nested class defined inside the RecyclerView class
    inner class EngineeringViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_engineering, parent, false)
    ) {

        private val engineeringImage: ImageView = itemView.findViewById(R.id.engineeringImage)
        private val engineeringName: TextView = itemView.findViewById(R.id.engineeringName)
        private val engineeringDescription: TextView =
            itemView.findViewById(R.id.engineeringDescription)
        private val button: Button = itemView.findViewById(R.id.button)

        fun onBind(engineering: Engineering) {
            engineeringImage.setImageResource(engineering.imageDrawable)
            engineeringName.text = engineering.engineeringName
            engineeringDescription.text = engineering.engineeringDescription
            button.text = engineering.buttonText

            // This define what happen when the button is clicked
            button.setOnClickListener {
                Toast.makeText(it.context, "$adapterPosition clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // onCreateViewHolder => responsible for creating a new ViewHolder instance that represents an
    // item in the RecyclerView
    // The method inflates the layout for the individual items and creates a ViewHolder to
    // hold the inflated view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngineeringViewHolder {
        return EngineeringViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: EngineeringViewHolder, position: Int) {
        holder.onBind(data[position])
    }

}