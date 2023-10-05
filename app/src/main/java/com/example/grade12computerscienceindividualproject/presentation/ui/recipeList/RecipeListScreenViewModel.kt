package com.example.grade12computerscienceindividualproject.presentation.ui.recipeList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.grade12computerscienceindividualproject.domain.model.Recipe
import com.example.grade12computerscienceindividualproject.utils.RecipeListFilter

/**
 * A recipe list screen fragment
 *
 * @property originalRecipeList
 * @property recipeList
 */
class RecipeListScreenViewModel(
    private val originalRecipeList: List<Recipe>
) : ViewModel() {
    private val recipeList: MutableState<List<Recipe>> = mutableStateOf(ArrayList())

    init {
        recipeList.value = originalRecipeList
    }

    /**
     * Filter the recipeList based on recipe name
     */
    fun filterRecipeList (recipeName: String) {
        recipeList.value = RecipeListFilter.filterRecipeListByName(recipeName, recipeList.value)
    }
}
