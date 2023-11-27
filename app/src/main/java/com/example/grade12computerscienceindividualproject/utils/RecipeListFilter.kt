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
        fun getSortedRecipeListByRatingWithBucketSort(recipeList: List<Recipe>) : List<Recipe> {
            val bucketArray : MutableList<MutableList<Recipe>> = mutableListOf()
            for (i in 0..50)
                bucketArray.add(mutableListOf())
            for (recipe in recipeList) {
                bucketArray[(recipe[1].aggregateRating.ratingValue * 10).roundToInt()].add(recipe)
            }
            val tempRecipeList : MutableList<Recipe> = mutableListOf()
            for (list in bucketArray) {
                for (recipe in list) {
                    tempRecipeList.add(recipe)
                }
            }
            return tempRecipeList
        }

        fun getSortedRecipeListByRatingWithSelectionSort(recipeList: List<Recipe>) : List<Recipe> {
            val tempRecipeList : MutableList<Recipe> = recipeList.toMutableList()

            for (i in recipeList.indices) {
                var smallestRecipeIndex = i
                for (j in (i + 1) until recipeList.size) {
                    if (tempRecipeList[smallestRecipeIndex][1].aggregateRating.ratingValue <
                        tempRecipeList[j][1].aggregateRating.ratingValue) {
                        smallestRecipeIndex = j
                    }
                }
                val tempRecipe = tempRecipeList[smallestRecipeIndex]
                tempRecipeList[smallestRecipeIndex] = tempRecipeList[i]
                tempRecipeList[i] = tempRecipe
            }
            return tempRecipeList
        }

        fun searchRecipeByName(recipeList: List<Recipe>, recipeName: String): Recipe {
            return binarySearch(recipeList, recipeName, 0, recipeList.size - 1)
        }

        private fun binarySearch(input: List<Recipe>, searchItem: String, low:Int, high:Int): Recipe {
            while(low <= high) {
                val mid = (low + high) /2
                when {
                    searchItem > input[mid][1].name ->
                        return binarySearch(input, searchItem, mid + 1, high)   // element is greater than middle element of array, so it will be in right half. Recursion will call the right half again
                    searchItem < input[mid][1].name ->
                        return binarySearch(input, searchItem, low, mid - 1)    //element is less than middle element of array, so it will be in left half of the array. Recursion will call the left half again.
                    searchItem == input[mid][1].name -> return input[mid] // element found.
                }
            }
            return input[0]
        }
    }
}
