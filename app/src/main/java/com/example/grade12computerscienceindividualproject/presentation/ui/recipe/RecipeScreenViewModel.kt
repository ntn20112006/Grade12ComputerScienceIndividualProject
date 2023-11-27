package com.example.grade12computerscienceindividualproject.presentation.ui.recipe

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.grade12computerscienceindividualproject.domain.model.Recipe
import com.example.grade12computerscienceindividualproject.presentation.ui.recipeList.getRecipeListScreenViewModel
import com.example.grade12computerscienceindividualproject.utils.ModifyRecipeInformationForUI
import com.example.grade12computerscienceindividualproject.utils.RecipeListFilter
import java.lang.StringBuilder
import java.math.BigDecimal
import java.math.RoundingMode

class RecipeScreenViewModel (
    argument: Bundle
) : ViewModel() {
    val recipe: Recipe

    init {
        recipe = RecipeListFilter.searchRecipeByName(
            getRecipeListScreenViewModel().recipeList.value, argument.getString("RecipeName")!!)
    }

    fun getRecipeScreenUITitleText(): String {
        return recipe[1].name
    }

    fun getRecipeScreenUISubTitleText(): String {
        val authors = StringBuilder()
        authors.append("By ")
        for (author in recipe[1].author) {
            authors.append(author.name + ",")
        }
        val publishedDate = "Published on: " + recipe[1].datePublished.subSequence(0, 10)
        return authors.subSequence(0, authors.length - 1).toString() + "\n" +
                publishedDate
    }

    fun getRecipeScreenUIBodyText(): String {
        val rating = "Rating: " + BigDecimal(recipe[1].aggregateRating.ratingValue)
            .setScale(2, RoundingMode.HALF_UP).toString() +
                " (" + recipe[1].aggregateRating.ratingCount + " ratings)"
        val description = "Description:\n\t\t" + recipe[1].description
        var cookTimeArray: List<String>? = null
        if (recipe[1].totalTime != null)
            cookTimeArray = ModifyRecipeInformationForUI.getRecipeCookTime(recipe[1].totalTime.toString())
        var cookTime = "Total cook time: Unknown"
        if (cookTimeArray != null) {
            cookTime = "Total cook time required: " +
                cookTimeArray[0] + " days, " +
                cookTimeArray[1] + " hours, " +
                cookTimeArray[2] + " minutes"
        }
        val nutrition = "Nutritions:" +
                "\n\tCalories: " + recipe[1].nutrition.calories +
                "\n\tCarbohydrates: " + recipe[1].nutrition.carbohydrateContent +
                "\n\tFat: " + recipe[1].nutrition.fatContent +
                "\n\tSaturated fat: " + recipe[1].nutrition.saturatedFatContent +
                "\n\tCholesterol content: " + recipe[1].nutrition.cholesterolContent +
                "\n\tProtein: " + recipe[1].nutrition.proteinContent +
                "\n\tFiber: " + recipe[1].nutrition.fiberContent +
                "\n\tSodium: " + recipe[1].nutrition.sodiumContent +
                "\n\tSugar: " + recipe[1].nutrition.sugarContent
        return rating + "\n" + cookTime + "\n\n" + description + "\n\n" + nutrition
    }
}
