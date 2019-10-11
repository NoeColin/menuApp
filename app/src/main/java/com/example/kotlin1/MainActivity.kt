package com.example.kotlin1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardOpenOption
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

   val repas = arrayListOf<String>("Repas étudiant: Spaghetti bolo", "Sauté de courgettes aux petits oignons", "Pommes dauphines et steak haché", "Manges ta main et gardes l'autre pour demain", "Poulet aux olives et riz", "go commander chinois", "Couscous", "Poulet roti et purée mousseline", "Hot dog", "ratatouille")
    var nbrMenus = 10
    val fileName = "src/resources/myfile.txt"
    val myfile = File(fileName)

    val content = "Today snow is falling.\n"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val baseMenu = Random.nextInt(0, nbrMenus)
        mttxt.text = repas[baseMenu]
    }

    fun changetxt(view : View){
        mttxt.text = repas[Random.nextInt(0, nbrMenus)]
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addMenu(view : View){
        repas.add(addMenuInput.text.toString())
        nbrMenus++
        addMenuInput.setText("")
        Files.write(myfile.toPath(), content.toByteArray(), StandardOpenOption.APPEND)
    }
}
