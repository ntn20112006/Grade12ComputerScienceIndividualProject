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
