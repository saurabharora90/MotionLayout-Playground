package com.example.androidweeklyplayground.weekly_481

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun BallScaleIndicator(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "ball")
    val spec = infiniteRepeatable<Float>(animation = tween(durationMillis = 900))

    val alpha by transition.animateFloat(
        initialValue = 1.0f,
        targetValue = 0.0f,
        animationSpec = spec,
        label = "ballAlpha"
    )

    val scale by transition.animateFloat(
        initialValue = 0.0f,
        targetValue = 1.0f,
        animationSpec = spec,
        label = "ballScale"
    )

    Ball(alpha = alpha, scale = scale, modifier = modifier.fillMaxSize())
}

@Composable
private fun Ball(
    alpha: Float,
    scale: Float,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.graphicsLayer {
        this.alpha = alpha
        this.scaleX = scale
        this.scaleY = scale
    },
        onDraw = {
            drawCircle(color = Color.LightGray)
        })
}