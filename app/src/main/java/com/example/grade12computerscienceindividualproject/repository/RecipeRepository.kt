package com.example.grade12computerscienceindividualproject.repository

import android.content.Context
import com.example.grade12computerscienceindividualproject.domain.model.Recipe
import com.google.gson.Gson

/**
 * A class to interact with external data
 */
class RecipeRepository {
    companion object {
        /**
         * Read and a recipe json file
         * @return the recipe object
         */
        fun getRecipeFromJSON(path: String, context: Context): Recipe {
            val file = context.assets.open(path).bufferedReader().use {
                it.readText()
            }
            val gson = Gson()
            return gson.fromJson(file, Recipe::class.java)
        }
    }
}
