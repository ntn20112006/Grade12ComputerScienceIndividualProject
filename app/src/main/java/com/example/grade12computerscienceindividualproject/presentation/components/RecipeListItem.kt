package com.example.grade12computerscienceindividualproject.presentation.components

import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.grade12computerscienceindividualproject.R
import com.example.grade12computerscienceindividualproject.domain.model.Recipe
import com.example.grade12computerscienceindividualproject.presentation.ui.recipeList.getRecipeListScreenViewModel

/**
 * Composable for recipe list individual recipe
 */
@Composable
fun RecipeListItem(recipe: Recipe) {
    val bundle = Bundle().apply {
        putString("RecipeName", recipe[1].name)
    }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clickable {
                findNavController(getRecipeListScreenViewModel().fragment)
                    .navigate(R.id.recipeFragment, bundle)
            }
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            // TODO Add image of recipe
            RecipeListItemDescription(recipe)
        }
    }
}

/**
 * Composable for recipe list individual recipe description
 */
@Composable
fun RecipeListItemDescription(recipe: Recipe) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(text = recipe[1].name,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth())
        Text(text = recipe[1].description,
            color = Color.White,
            fontSize = 15.sp,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth())
    }
}
