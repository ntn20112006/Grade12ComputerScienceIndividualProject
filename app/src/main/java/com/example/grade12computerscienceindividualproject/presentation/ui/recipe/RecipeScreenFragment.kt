package com.example.grade12computerscienceindividualproject.presentation.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment

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
        viewModel = RecipeScreenViewModel(requireArguments())
        return ComposeView(requireContext()).apply {
            setContent {
                Column {
                    Text(
                        text = viewModel.getRecipeScreenUITitleText(),
                        color = Color.White,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = viewModel.getRecipeScreenUISubTitleText(),
                        color = Color.White,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = viewModel.getRecipeScreenUIBodyText(),
                        color = Color.White,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(10.dp)
                    )
                }
            }
        }
    }
}
