package com.example.grade12computerscienceindividualproject.presentation.ui.recipeList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.grade12computerscienceindividualproject.domain.model.Recipe

class RecipeListScreenViewModel : ViewModel() {
    private val recipeList: MutableState<List<Recipe>> = mutableStateOf(ArrayList())

    fun filterRecipeList (recipeName: String) {
        // TODO Filter recipe list
    }
}
