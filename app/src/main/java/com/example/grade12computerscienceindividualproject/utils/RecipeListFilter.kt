package com.example.grade12computerscienceindividualproject.utils

import com.example.grade12computerscienceindividualproject.domain.model.Recipe
import kotlin.math.roundToInt

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

        /**
         * Sort recipe list by name
         *
         * @param recipeList the original recipe list
         * @return the filtered list of recipe
         */
        fun getSortedRecipeListByName(recipeList: List<Recipe>) : List<Recipe> {
            val tempRecipeList : MutableList<Recipe> = recipeList.toMutableList()
            for (i in recipeList.indices) {
                var smallestRecipeIndex = i
                for (j in (i + 1) until recipeList.size) {
                    if (tempRecipeList[smallestRecipeIndex][1].name.compareTo(tempRecipeList[j][1].name,
                            ignoreCase = true) > 0) {
                        smallestRecipeIndex = j
                    }
                }
                val tempRecipe = tempRecipeList[smallestRecipeIndex]
                tempRecipeList[smallestRecipeIndex] = tempRecipeList[i]
                tempRecipeList[i] = tempRecipe
            }
            return tempRecipeList
        }

        /**
         * Sort recipe list by rating
         *
         * @param recipeList the original recipe list
         * @return the filtered list of recipe
         */
        fun getSortedRecipeListByRating(recipeList: List<Recipe>) : List<Recipe> {
            val bucketArray : Array<MutableList<Recipe>> = arrayOf(mutableListOf(),
                mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf())
            for (recipe in recipeList) {
                bucketArray[recipe[1].aggregateRating.ratingValue.roundToInt()].add(recipe)
            }
            val tempRecipeList : MutableList<Recipe> = recipeList.toMutableList()
            for (list in bucketArray) {
                for (recipe in list) {
                    tempRecipeList.add(recipe)
                }
            }
            return tempRecipeList
        }
    }
}
