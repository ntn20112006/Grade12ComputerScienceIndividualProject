package com.example.grade12computerscienceindividualproject.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.grade12computerscienceindividualproject.R
import com.example.grade12computerscienceindividualproject.presentation.ui.recipeList.RecipeListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {}