package com.managerofthings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.managerofthings.sqllite.AppDatabase
import com.managerofthings.ui.MenuView
import com.managerofthings.ui.theme.BookManagerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "my_bullshit_db"
        ).build()

        val bullshitDao = db.bullshitDAO()
        val categoryDAO = db.categoryDAO()
        val categoryHasTagsDAO = db.categoryHasTagDAO()
        val containsDAO = db.containsDAO()
        val tagsDAO = db.tagsDAO()


        lifecycleScope.launch {
            println("CIAOOOOOOOO")
            println(bullshitDao.getSchoolWithStudents(1))
            /*bullshitDao.insertBullshit(
                Bullshit(
                    id = 1,
                    name = "prova",
                    description = "prova",
                    image = byteArrayOf(0xA),
                    time = "ciao"
                )
            )*/

            /*
            categoryDAO.insertCategory(
                Category(
                    name = "divertente"
                )
            )
             */

            //containsDAO.deleteAll()

            /*
            containsDAO.insertContains(
                Contains(
                    id = 1,
                    name = "divertente"
                )
            )
             */
        }

        setContent {
            BookManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    MenuView()
                }
            }
        }
    }
}