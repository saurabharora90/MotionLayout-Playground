package com.example.androidweeklyplayground.weekly_481

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun TriangleSkewSpinIndicator(modifier: Modifier = Modifier) {
    val rotationX = remember { Animatable(0.0f) }
    val rotationY = remember { Animatable(0.0f) }

    Triangle(modifier.graphicsLayer {
        this.rotationX = rotationX.value
        this.rotationY = rotationY.value
    })

    LaunchedEffect(Unit) {
        val animationSpec = tween<Float>(durationMillis = 600, easing = LinearEasing)
        while (true) {
            if (rotationX.value == 180f)
                rotationX.animateTo(0f, animationSpec)
            else
                rotationX.animateTo(180f, animationSpec)

            if (rotationY.value == 180f)
                rotationY.animateTo(0f, animationSpec)
            else
                rotationY.animateTo(180f, animationSpec)
        }
    }
}

private val triangleShape = GenericShape { size, _ ->
    moveTo(0f, size.height)
    lineTo(size.width, size.height)
    lineTo(size.width / 2, 0f)
}

@Composable
private fun Triangle(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(triangleShape)
            .background(Color.LightGray)
    )
}