package com.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), EngineeringInterface {

    private lateinit var engineeringList: ArrayList<Engineering>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set the toolbar created in the layout as the ActionBar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.apply {
            title = "My First App"
        }

        // creating a list containing each item to be put in the recycler view
        engineeringList = createListOfEngineering()

        val engineeringAdapter = EngineeringAdapter(engineeringList, this)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        // or we can write
        // val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.adapter = engineeringAdapter

        engineeringAdapter.notifyDataSetChanged()
    }

    override fun onLearnMoreButtonClicked(position: Int) {
        val engineering = engineeringList[position]
        val intent = Intent(this, EngineeringDetailActivity::class.java).apply {
            putExtra("engineering", engineering)
        }
        startActivity(intent)
    }

    private fun createListOfEngineering(): ArrayList<Engineering> {
        return ArrayList<Engineering>().apply {
            add(
                Engineering(
                    engineeringName = "Civil Engineering",
                    engineeringDescription = "Focuses on the design, construction, and maintenance of infrastructure projects such as roads, bridges, buildings, and water supply systems.",
                    engineeringLongDescription = "Civil engineers are responsible for the design, construction, and maintenance of infrastructure projects such as roads, bridges, buildings, dams, and water supply systems. They ensure that these structures are not only functional but also safe, sustainable, and cost-effective.",
                    buttonText = "Learn More",
                    imageURL = "https://www.clarkson.edu/sites/default/files/2023-05/Civil-Engineering-Hero-1600x900.jpg",
                    imageDrawable = R.drawable.civil,
                    engineeringLink = "https://en.wikipedia.org/wiki/Civil_engineering"
                )
            )

            add(
                Engineering(
                    engineeringName = "Electrical Engineering",
                    engineeringDescription = "Focuses on the study and application of electricity, electronics, and electromagnetism in various systems, including power generation, communication, and control systems.",
                    engineeringLongDescription = "Electrical engineers specialize in the study and application of electricity, electronics, and electromagnetism. They work on a variety of systems, including power generation, transmission, and distribution, as well as electronic circuits, telecommunications, and control systems. Their work ranges from designing microchips and computer systems to developing power generation technologies and renewable energy sources.",
                    buttonText = "Learn More",
                    imageURL = "https://upload.wikimedia.org/wikipedia/commons/9/92/Umspannwerk-Pulverdingen_380kV-Trennschalter.jpg",
                    imageDrawable = R.drawable.electrical,
                    engineeringLink = "https://en.wikipedia.org/wiki/Electrical_engineering"
                )
            )

            add(
                Engineering(
                    engineeringName = "Mechanical Engineering",
                    engineeringDescription = "Involves the design, development, and maintenance of mechanical systems, including machines, engines, and tools.",
                    engineeringLongDescription = "Mechanical engineers work on the design, development, and maintenance of mechanical systems. They deal with machines, engines, and tools, ensuring that these systems operate efficiently and reliably. This field includes a broad range of applications, from automotive and aerospace technology to manufacturing processes and robotics.",
                    buttonText = "Learn More",
                    imageURL = "https://www.clarkson.edu/sites/default/files/2023-06/Mechanical-Engineering-MS-Professionals-Hero-1600x900_0.jpg",
                    imageDrawable = R.drawable.mechanical,
                    engineeringLink = "https://en.wikipedia.org/wiki/Mechanical_engineering"
                )
            )

            add(
                Engineering(
                    engineeringName = "Computer Engineering",
                    engineeringDescription = "Combines elements of computer science and electrical engineering to design and develop computer hardware and software systems.",
                    engineeringLongDescription = "Computer engineers integrate elements of computer science and electrical engineering to design and develop computer hardware and software systems. They work on a wide range of computing devices, from microprocessors and circuit boards to software applications and networking systems. Computer engineers play a crucial role in advancing technology, driving innovation, and shaping the digital world.",
                    buttonText = "Learn More",
                    imageURL = "https://online.engineering.arizona.edu/wp-content/themes/eng/images/blog/top-skills-software-and-computer-engineering.jpg",
                    imageDrawable = R.drawable.computer,
                    engineeringLink = "https://en.wikipedia.org/wiki/Computer_engineering"
                )
            )

            add(
                Engineering(
                    engineeringName = "Industrial Engineering",
                    engineeringDescription = "Involves the optimization of complex processes or systems by improving efficiency, productivity, and quality in various industries.",
                    engineeringLongDescription = "Industrial engineers optimize complex processes or systems by improving efficiency, productivity, and quality in various industries. They use their expertise in engineering, mathematics, and business to streamline production processes, reduce costs, and enhance overall operational performance. Industrial engineers work across different sectors, including manufacturing, logistics, healthcare, and service industries, contributing to the effective and efficient management of resources and operations.",
                    buttonText = "Learn More",
                    imageURL = "https://blogassets.leverageedu.com/blog/wp-content/uploads/2019/12/20190128/Industrial-Engineering.jpg",
                    imageDrawable = R.drawable.industrial,
                    engineeringLink = "https://en.wikipedia.org/wiki/Industrial_engineering"
                )
            )
        }
    }
}