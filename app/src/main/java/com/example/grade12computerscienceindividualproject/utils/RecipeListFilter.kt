package com.example.grade12computerscienceindividualproject.utils

import com.example.grade12computerscienceindividualproject.domain.model.Recipe

/**
 * A class to filter recipe list
 */
class RecipeListFilter {
    companion object {
        /**
         * Filter recipe list by name
         */
        fun filterRecipeListByName(recipeName: String, recipeList: MutableList<Recipe>) {
            for (recipe in recipeList) {
                if (recipe[1].name != recipeName) {
                    recipeList.remove(recipe)
                }
            }
        }
    }
}
