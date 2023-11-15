package com.example.grade12computerscienceindividualproject.presentation.ui.recipeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.Fragment
import com.example.grade12computerscienceindividualproject.presentation.components.RecipeList
import com.example.grade12computerscienceindividualproject.presentation.components.RecipeListTopBar
import com.example.grade12computerscienceindividualproject.repository.RecipeRepository

/**
 * A recipe list screen fragment
 */
class RecipeListFragment : Fragment() {
    /**
     * @return a composable for recipe list screen
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    RecipeListTopBar()
                    val recipe = listOf(RecipeRepository.getRecipeFromJSON("Recipe1.json", LocalContext.current))
                    RecipeList(recipe)
                }
            }
        }
    }
}
