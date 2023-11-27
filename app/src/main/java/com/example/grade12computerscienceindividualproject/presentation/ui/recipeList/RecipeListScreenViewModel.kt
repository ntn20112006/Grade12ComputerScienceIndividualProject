package com.example.grade12computerscienceindividualproject.presentation.ui.recipeList

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.grade12computerscienceindividualproject.domain.model.Recipe
import com.example.grade12computerscienceindividualproject.repository.RecipeRepository
import com.example.grade12computerscienceindividualproject.utils.RecipeListFilter
import com.example.grade12computerscienceindividualproject.utils.SelectionSort
import com.example.grade12computerscienceindividualproject.utils.SortingAlgorithm

/**
 * A recipe list screen fragment
 *
 * @property originalRecipeList
 * @property recipeList
 */
class RecipeListScreenViewModel(
    context: Context,
    val fragment: Fragment
) : ViewModel() {
    val recipeList: MutableState<List<Recipe>> = mutableStateOf(ArrayList())
    private val originalRecipeList: List<Recipe>

    init {
        val mutableList = mutableListOf<Recipe>()
        for (i in 1..20) {
            mutableList.add(RecipeRepository.getRecipeFromJSON("Recipe$i.json", context))
        }
        val sorter: SortingAlgorithm = SelectionSort()
        originalRecipeList = sorter.sortByName(mutableList)
        recipeList.value = originalRecipeList
    }

    /**
     * Filter the recipeList based on recipe name
     */
    fun filterRecipeList (recipeName: String) {
        recipeList.value = RecipeListFilter.filterRecipeListByName(recipeName, originalRecipeList)
    }
}
