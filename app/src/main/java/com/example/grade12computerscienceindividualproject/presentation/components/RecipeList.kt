package com.example.grade12computerscienceindividualproject.presentation.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.grade12computerscienceindividualproject.domain.model.Recipe

/**
 * Composable for recipe list
 */
@Composable
fun RecipeList(recipeList: List<Recipe>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(recipeList.size) { i ->
            RecipeListItem(recipe = recipeList[i])
        }
    }
}
