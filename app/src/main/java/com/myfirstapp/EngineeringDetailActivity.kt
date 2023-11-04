package com.myfirstapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

// This activity will show on the screen when we click on "Learn More" in one of the cards
// from home screen (main activity)

// AppCompatActivity -> we have to use this when creating a activity
class EngineeringDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_engineering_detail)

        // set the toolbar created in the layout as the ActionBar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)     // set the arrow on the left (to go back a screen)
            title = "Engineering Overview"
        }

        val engineering = intent.getSerializableExtra("engineering") as? Engineering ?: Engineering(
            engineeringName = "Whoops",
            engineeringDescription = "Something went wrong. Please, try again"
        )
        // ?: Engineering() -> we need this part in order to avoid an error

        val engineeringImage: ImageView = findViewById(R.id.engineeringImage)
        val engineeringName: TextView = findViewById(R.id.engineeringName)
        val engineeringDescription: TextView = findViewById(R.id.engineeringDescription)
        val engineeringLongDescription: TextView = findViewById(R.id.engineeringLongDescription)

        engineeringImage.setImageResource(engineering.imageDrawable)
        engineeringName.text = engineering.engineeringName
        engineeringDescription.text = engineering.engineeringDescription
        engineeringLongDescription.text = engineering.engineeringLongDescription
    }

    // When the arrow is clicked, the app must go back as screen (in this case, go to home screen)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()    // finishes activity (go back to home screen in this case)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}