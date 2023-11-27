package com.example.grade12computerscienceindividualproject.presentation.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.grade12computerscienceindividualproject.presentation.ui.recipeList.getRecipeListScreenViewModel
import com.example.grade12computerscienceindividualproject.utils.RecipeListFilter

private lateinit var viewModel: RecipeScreenViewModel

fun getRecipeScreenViewModel() : RecipeScreenViewModel {
    return viewModel
}

class RecipeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val argument = arguments
        val recipe = RecipeListFilter.filterRecipeListByName(
            argument!!.getString("RecipeName")!!,
            getRecipeListScreenViewModel().recipeList.value)[0]
        return ComposeView(requireContext()).apply {
            setContent {
                Text(text = recipe[1].name)
            }
        }
    }
}
