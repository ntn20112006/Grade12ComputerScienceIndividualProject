package com.example.grade12computerscienceindividualproject.repository

import android.content.Context
import android.util.Log
import com.example.grade12computerscienceindividualproject.domain.model.Recipe
import com.google.gson.Gson
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

/**
 * A class to interact with external data
 */
class RecipeRepository {
    companion object {
        /**
         * Read a recipe json file
         *
         * @param path the path of the file wanted to be read
         * @param context the context required to get to the assets folder
         * @return the recipe object
         */
        fun getRecipeFromJSON(path: String, context: Context): Recipe {
            val file = context.assets.open(path).bufferedReader().use {
                it.readText()
            }
            val gson = Gson()
            return gson.fromJson(file, Recipe::class.java)
        }

        /**
         * Write a recipe json file
         *
         * @param fileName the name of the soon to be created file
         * @param recipe the recipe information for the soon to be created file
         */
        fun writeNewJSONRecipe(fileName: String, recipe: Recipe) {
            try {
                val file = File("app/src/main/assets/$fileName")
                if (file.exists()) {
                    // TODO Show that file already exist
                    return
                }
                file.createNewFile()
                File("app/src/main/assets/$fileName").writeText(Json.encodeToString(recipe))
            } catch (e: Exception) {
                // TODO Show user that something is wrong
                Log.i("Error", e.message.toString())
            }
        }
    }
}
