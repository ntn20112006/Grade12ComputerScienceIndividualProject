package com.example.grade12computerscienceindividualproject.presentation.ui.recipeList

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.example.grade12computerscienceindividualproject.domain.model.Recipe
import com.example.grade12computerscienceindividualproject.repository.RecipeRepository
import com.example.grade12computerscienceindividualproject.utils.RecipeListFilter

/**
 * A recipe list screen fragment
 *
 * @property originalRecipeList
 * @property recipeList
 */
class RecipeListScreenViewModel(
    context: Context
) : ViewModel() {
    val recipeList: MutableState<List<Recipe>> = mutableStateOf(ArrayList())
    private val originalRecipeList: List<Recipe>

    init {
        val mutableList = mutableListOf<Recipe>()
        for (i in 1..10) {
            mutableList.add(RecipeRepository.getRecipeFromJSON("Recipe$i.json", context))
        }
        originalRecipeList = mutableList
        recipeList.value = originalRecipeList
    }

    /**
     * Filter the recipeList based on recipe name
     */
    fun filterRecipeList (recipeName: String) {
        recipeList.value = RecipeListFilter.filterRecipeListByName(recipeName, recipeList.value)
    }
}
