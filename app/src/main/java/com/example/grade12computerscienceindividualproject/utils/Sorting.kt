package com.example.grade12computerscienceindividualproject.utils

import com.example.grade12computerscienceindividualproject.domain.model.Recipe
import kotlin.math.roundToInt

interface SortingAlgorithm {
    fun sortByRating(list: List<Recipe>): List<Recipe>

    fun sortByName(list: List<Recipe>): List<Recipe>
}

class SelectionSort : SortingAlgorithm {
    override fun sortByRating(list: List<Recipe>): List<Recipe> {
        val tempRecipeList : MutableList<Recipe> = list.toMutableList()

        for (i in list.indices) {
            var smallestRecipeIndex = i
            for (j in (i + 1) until list.size) {
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

    override fun sortByName(list: List<Recipe>): List<Recipe> {
        val tempRecipeList : MutableList<Recipe> = list.toMutableList()
        for (i in list.indices) {
            var smallestRecipeIndex = i
            for (j in (i + 1) until list.size) {
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
}

abstract class BucketSort : SortingAlgorithm {
    override fun sortByRating(list: List<Recipe>): List<Recipe> {
        val bucketArray : MutableList<MutableList<Recipe>> = mutableListOf()
        for (i in 0..50)
            bucketArray.add(mutableListOf())
        for (recipe in list) {
            bucketArray[(recipe[1].aggregateRating.ratingValue * 10).roundToInt()].add(recipe)
        }
        val tempRecipeList : MutableList<Recipe> = mutableListOf()
        for (bucketList in bucketArray) {
            for (recipe in bucketList) {
                tempRecipeList.add(recipe)
            }
        }
        return tempRecipeList
    }
}