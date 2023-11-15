package com.example.grade12computerscienceindividualproject.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.grade12computerscienceindividualproject.presentation.ui.recipeList.getRecipeListScreenViewModel

/**
 * Composable for recipe list top bar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
    ) {
        SearchBar(::search)
    }
}

/**
 * Just a temporary function, serve no special purpose
 */
fun search(input: String) {
    getRecipeListScreenViewModel().filterRecipeList(input)
}
