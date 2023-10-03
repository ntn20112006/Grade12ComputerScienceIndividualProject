package com.example.grade12computerscienceindividualproject.repository

import android.content.Context
import com.example.grade12computerscienceindividualproject.domain.model.Recipe
import com.google.gson.Gson

class RecipeRepository {
    companion object {
        fun getRecipeFromJSON(path: String, context: Context): Recipe {
            val file = context.assets.open(path).bufferedReader().use {
                it.readText()
            }
            val gson = Gson()
            return gson.fromJson(file, Recipe::class.java)
        }
    }
}
