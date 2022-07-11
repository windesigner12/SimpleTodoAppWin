package com.example.simpletodoapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.FileUtils
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.apache.commons.io.FileUtils.readLines
import org.apache.commons.io.FileUtils.writeLines
import java.io.File
import java.io.IOException
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {

    var listOfTasks = mutableListOf<String>()

    lateinit var adapter : TaskItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onLongClickListener = object : TaskItemAdapter.OnLongClickListener {
            override fun onItemLongClicked(position: Int) {
                listOfTasks.removeAt(position)
                adapter.notifyDataSetChanged()

           //     saveItems()
            }

        }

      //loadItems()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = TaskItemAdapter(listOfTasks, onLongClickListener)

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

        val inputTextField = findViewById<EditText>(R.id.addTaskField)


        findViewById<Button>(R.id.button).setOnClickListener{
            // Grab the text
            val userInputtedTask = inputTextField.text.toString()
            //Add the String to the list of task
            listOfTasks.add(userInputtedTask)

            //Notify the Datat Adapter
            adapter.notifyItemInserted(listOfTasks.size -1)

            //Reset the field
            inputTextField.setText(" ")

           // saveItems()
        }

    }


    ///Save the data that user has inputted

    //save data by Writting and reading

    //Get the file we need
//    fun getDataFile() : File {
//
//        return File(filesDir, "data.txt")
//    }
//    // Load the items by rading every line in the data file
//
//    fun loadItems(){
//        try{
//            listOfTasks = FileUtils.readLines(getDataFile(), Charset.defaultCharset())
//
//        }catch (ioException: IOException){
//            ioException.printStackTrace()
//        }
//   }
//    // save items by writting them into our data file
//
//fun saveItems() {
//try {
//    FileUtils.writeLines(getDataFile(), listOfTasks)
//}catch (ioException : IOException){
//   ioException.printStackTrace()
//}

//}


}