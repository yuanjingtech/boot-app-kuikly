package com.tencent.kuikly.compose.material3

import androidx.compose.runtime.Composable
import com.tencent.kuikly.compose.ui.Modifier

//ref https://kotlinlang.org/api/compose-multiplatform/material3/androidx.compose.material3/-outlined-text-field.html
@ExperimentalMaterial3Api
@Composable
fun OutlinedTextField(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit = {},
    placeholder: @Composable () -> Unit = {},
    singleLine: Boolean = true,
    maxLines: Int = 1
) {
    TextField(value, onValueChange, modifier)
}
