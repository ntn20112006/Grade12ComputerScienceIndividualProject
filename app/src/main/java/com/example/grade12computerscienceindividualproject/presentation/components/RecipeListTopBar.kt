package com.example.grade12computerscienceindividualproject.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
    ) {
        //TODO Pass in the logic function in the future
        SearchBar(::temp)
    }
}

fun temp(temp: String) {}
