package com.example.grade12computerscienceindividualproject.utils

import com.example.grade12computerscienceindividualproject.domain.model.Recipe

/**
 * A class to filter recipe list
 */
class RecipeListFilter {
    companion object {
        /**
         * Filter recipe list by name
         *
         * @param recipeName the name of the recipe wanted to be white list filtered
         * @param recipeList the original recipe list
         * @return the already filtered recipe list
         */
        fun filterRecipeListByName(recipeName: String, recipeList: List<Recipe>) : List<Recipe> {
            val tempRecipeList : MutableList<Recipe> = ArrayList()
            for (recipe in recipeList) {
                if (recipe[1].name.lowercase().contains(recipeName.lowercase())) {
                    tempRecipeList.add(recipe)
                }
            }
            return tempRecipeList
        }
    }
}
