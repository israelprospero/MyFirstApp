package com.myfirstapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView

class EngineeringAdapter(
    private val data: ArrayList<Engineering>,   // this is like a global variable
    private val engineeringInterface: EngineeringInterface
) : RecyclerView.Adapter<EngineeringAdapter.EngineeringViewHolder>() {

    // EngineeringViewHolder inherits from RecyclerView
    // ViewHolder is a nested class defined inside the RecyclerView class
    inner class EngineeringViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_engineering, parent, false)
    ) {

        private val engineeringImage: ImageView = itemView.findViewById(R.id.engineeringImage)
        private val engineeringName: TextView = itemView.findViewById(R.id.engineeringName)
        private val engineeringDescription: TextView =
            itemView.findViewById(R.id.engineeringDescription)
        private val button: Button = itemView.findViewById(R.id.button)
        private val favoriteImageView : AppCompatImageView = itemView.findViewById(R.id.favoriteImageView)

        fun onBind(engineering: Engineering, engineeringInterface: EngineeringInterface) {
            engineeringImage.setImageResource(engineering.imageDrawable)
            engineeringName.text = engineering.engineeringName
            engineeringDescription.text = engineering.engineeringDescription
            button.text = engineering.buttonText

            // This define what happen when the button is clicked
            button.setOnClickListener {
                // Toast.makeText(it.context, "$adapterPosition clicked", Toast.LENGTH_SHORT).show()
                // adapterPosition => position of the item of the Recycler View

                engineeringInterface.onLearnMoreButtonClicked(adapterPosition)
            }
            val icon = if (engineering.isFavorite) R.drawable.ic_favorite_24dp else R.drawable.ic_favorite_border_24dp
            favoriteImageView.setImageResource(icon)
            favoriteImageView.setOnClickListener {
                engineeringInterface.onFavoriteClicked(adapterPosition)
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
        holder.onBind(data[position], engineeringInterface)
    }

}