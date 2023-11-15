package com.example.grade12computerscienceindividualproject.domain.model

import java.lang.Math.round
import kotlin.math.roundToInt

/**
 * An recipe object
 *
 *  @inheritdoc ArrayList<RecipeDetails>
 */
class Recipe: ArrayList<RecipeDetails>()

/**
 * An recipe description object
 *
 * @property aggregateRating the rating of this information of the recipe
 * @property author the information about the author of the recipe
 * @property cookTime the amount of time required to cook this recipe
 * @property datePublished the date of when this post was published
 * @property description a descriptive description about the recipe
 * @property image information about the image of the recipe
 * @property name name of the recipe
 * @property nutrition information about the nutrition value of the recipe
 * @property prepTime the amount of time required to prepare the ingredients for the recipe
 * @property recipeCategory a list of the different categories this food fall into
 * @property recipeIngredient a list of the different ingredients in this recipe
 * @property recipeInstructions a list of the different steps to cook this recipe
 * @property recipeYield the amount of item you will get from thsi recipe
 * @property review review from others about this recipe
 * @property totalTime the total time required to cook this recipe
 */
data class RecipeDetails(
    val aggregateRating: AggregateRating,
    val author: List<Author>,
    val cookTime: Any,
    val datePublished: String,
    val description: String,
    val image: Image,
    val name: String,
    val nutrition: Nutrition,
    val prepTime: Any,
    val recipeCategory: List<String>,
    val recipeIngredient: List<String>,
    val recipeInstructions: List<RecipeInstruction>,
    val recipeYield: String,
    val review: List<Review>,
    val totalTime: Any
)

/**
 * A recipe rating object
 *
 * @property ratingCount the number of rating
 * @property ratingValue the average value of all the rating
 */
data class AggregateRating(
    val ratingCount: Int,
    val ratingValue: Double,
)

/**
 * An author object
 *
 * @property name the name of the author
 */
data class Author(
    val name: String
)

/**
 * An image object
 *
 * @property height the original height of the image
 * @property width the original width of the image
 * @property url the url to the image
 */
data class Image(
    val height: Int,
    val url: String,
    val width: Int
)

/**
 * A nutrition object
 *
 * @property calories the amount of calories
 * @property carbohydrateContent the amount of carbohydrate
 * @property cholesterolContent the amount of cholesterol
 * @property fatContent the amount of fat
 * @property fiberContent the amount of fiber
 * @property proteinContent the amount of protein
 * @property saturatedFatContent the amount of saturated fat
 * @property sodiumContent the amount of sodium
 * @property sugarContent the amount of sugar
 */
class Nutrition(
    val calories: String,
    val carbohydrateContent: String,
    val cholesterolContent: String,
    val fatContent: String,
    val fiberContent: String,
    val proteinContent: String,
    val saturatedFatContent: String,
    val sodiumContent: String,
    val sugarContent: String
) {
    /**
     * A function to calculate the amount of calories in percentage when compare with the recommended daily value
     *
     * @return the percentage in the Integer form
     */
    fun getCaloriesPercentage(): Int {
        return removeUnit(calories) / 2500 * 100
    }

    /**
     * A function to calculate the amount of carbohydrate in percentage when compare with the recommended daily value
     *
     * @return the percentage in the Integer form
     */
    fun getCarbohydratePercentage(): Int {
        return removeUnit(carbohydrateContent) / 300 * 100
    }

    /**
     * A function to calculate the amount of cholesterol in percentage when compare with the recommended daily value
     *
     * @return the percentage in the Integer form
     */
    fun getCholesterolPercentage(): Int {
        return removeUnit(cholesterolContent) / 300 * 100
    }

    /**
     * A function to calculate the amount of fat in percentage when compare with the recommended daily value
     *
     * @return the percentage in the Integer form
     */
    fun getFatPercentage(): Int {
        return removeUnit(fatContent) / 70 * 100
    }

    /**
     * A function to calculate the amount of fiber in percentage when compare with the recommended daily value
     *
     * @return the percentage in the Integer form
     */
    fun getFiberPercentage(): Int {
        return removeUnit(fiberContent) / 35 * 100
    }

    /**
     * A function to calculate the amount of protein in percentage when compare with the recommended daily value
     *
     * @return the percentage in the Integer form
     */
    fun getProteinPercentage(): Int {
        return removeUnit(proteinContent) / 55 * 100
    }

    /**
     * A function to calculate the amount of saturated fat in percentage when compare with the recommended daily value
     *
     * @return the percentage in the Integer form
     */
    fun getSaturatedFatPercentage(): Int {
        return removeUnit(saturatedFatContent) / 22 * 100
    }

    /**
     * A function to calculate the amount of sodium in percentage when compare with the recommended daily value
     *
     * @return the percentage in the Integer form
     */
    fun getSodiumPercentage(): Int {
        return removeUnit(sodiumContent) / 2300 * 100
    }

    /**
     * A function to calculate the amount of sugar in percentage when compare with the recommended daily value
     *
     * @return the percentage in the Integer form
     */
    fun getSugarPercentage(): Int {
        return removeUnit(sugarContent) / 36 * 100
    }

    /**
     * A function to remove the unit of a nutrition and return it in the form of an integer
     *
     * @param input the string that contains the amount and unit of nutrition
     * @return the amount in integer
     */
    private fun removeUnit(input: String): Int {
        var temp = ""
        for (char in input) {
            if (char == ' ')
                break
            temp += char
        }
        return temp.toInt()
    }
}

/**
 * A recipe instruction object
 *
 * @property text the instruction of how to cook the recipe
 */
data class RecipeInstruction(
    val text: String
)

/**
 * A review object
 *
 * @property author the information about the author of the review
 * @property datePublished the date the review was published
 * @property reviewRating the rating of the review
 */
data class Review(
    val author: Author,
    val datePublished: String,
    val reviewRating: ReviewRating
)

/**
 * A review rating object
 *
 * @property ratingValue the rating in the review
 */
data class ReviewRating(
    val ratingValue: Int,
)
