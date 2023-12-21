package com.vdcast.cvs_test_task.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SideSheetEffect(
    visible: Boolean,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInHorizontally (
            animationSpec = tween(durationMillis = 300),
            initialOffsetX = { it }
        ),
        exit = slideOutHorizontally (
            animationSpec = tween(durationMillis = 300),
            targetOffsetX = { it }
        ),
    ) {
        content()
    }
}