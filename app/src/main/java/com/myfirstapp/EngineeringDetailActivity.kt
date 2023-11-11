package com.myfirstapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

// This activity will show on the screen when we click on "Learn More" in one of the cards
// from home screen (main activity)

// AppCompatActivity -> we have to use this when creating a activity
class EngineeringDetailActivity : AppCompatActivity() {

    private lateinit var engineering: Engineering
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_engineering_detail)

        // set the toolbar created in the layout as the ActionBar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)     // set the arrow on the left (to go back a screen)
            title = "Engineering Overview"
        }

//        engineering = intent.getSerializableExtra("engineering") as? Engineering ?: Engineering(
//            engineeringName = "Whoops",
//            engineeringDescription = "Something went wrong. Please, try again"
//        )
        // ?: Engineering() -> we need this part in order to avoid an error
        // the commented part was used when Engineering was Serializable

        val selectedEngineeringId = intent.getStringExtra("engineeringId")
        // MainActivity.engineeringList is referencing the static list that we have in MainActivity
        engineering = MainActivity.engineeringList.find {
            it.id == selectedEngineeringId
        } ?: Engineering(
            engineeringName = "Whoops",
            engineeringDescription = "Something went wrong. Please, try again"
        )

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
                true        // return that will be passed. In this case, it could be also false, it wouldn't change anything for us
            }

            // When we click the Link button (on the right) we have to go to the link of the wikipedia article about the engineering
            R.id.menuItemLink -> {
                //Log.i("URL", engineering.engineeringLink)
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(engineering.engineeringLink))
                startActivity(intent)
                true
            }

            R.id.menuItemFavorite -> {
                val isCurrentlyFavorited = engineering.isFavorite
                if (isCurrentlyFavorited) {
                    item.setIcon(R.drawable.ic_favorite_border_24dp)
                } else {
                    item.setIcon(R.drawable.ic_favorite_24dp)
                }

                engineering.isFavorite = !isCurrentlyFavorited
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    // We want to show the link button in the action bar (see menu_engineering_detail)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_engineering_detail, menu)

        if (engineering.isFavorite) {
            menu?.findItem(R.id.menuItemFavorite)?.setIcon(R.drawable.ic_favorite_24dp)
        }

        return true     // we are taking control and we inflated the menu
    }
}