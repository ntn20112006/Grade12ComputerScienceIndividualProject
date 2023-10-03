package com.example.grade12computerscienceindividualproject.domain.model

class Recipe: ArrayList<RecipeDetails>()

data class RecipeDetails(
    val aggregateRating: AggregateRating,
    val author: List<Author>,
    val cookTime: Any,
    val datePublished: String,
    val description: String,
    val image: Image,
    val itemListElement: List<ItemElement>,
    val mainEntityOfPage: String,
    val name: String,
    val nutrition: Nutrition,
    val prepTime: Any,
    val recipeCategory: List<String>,
    val recipeCuisine: List<Any>,
    val recipeIngredient: List<String>,
    val recipeInstructions: List<RecipeInstruction>,
    val recipeYield: String,
    val review: List<Review>,
    val totalTime: Any
)

data class AggregateRating(
    val bestRating: String,
    val itemReviewed: String,
    val ratingCount: Int,
    val ratingValue: Double,
    val worstRating: String
)

data class Author(
    val name: String
)

data class Image(
    val height: Int,
    val url: String,
    val width: Int
)

data class ItemElement(
    val item: Item,
    val position: Int
)

data class Nutrition(
    val calories: String,
    val carbohydrateContent: String,
    val cholesterolContent: String,
    val fatContent: String,
    val fiberContent: String,
    val proteinContent: String,
    val saturatedFatContent: String,
    val servingSize: Any,
    val sodiumContent: String,
    val sugarContent: String,
    val transFatContent: Any,
    val unsaturatedFatContent: Any
)

data class RecipeInstruction(
    val text: String
)

data class Review(
    val author: AuthorX,
    val datePublished: String,
    val reviewBody: String,
    val reviewRating: ReviewRating
)

data class Item(
    val image: Any,
    val name: String
)

data class AuthorX(
    val image: Any,
    val name: String,
    val sameAs: String
)

data class ReviewRating(
    val bestRating: String,
    val ratingValue: Int,
    val worstRating: String
)