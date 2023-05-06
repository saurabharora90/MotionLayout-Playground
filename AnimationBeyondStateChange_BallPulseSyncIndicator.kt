package com.example.androidweeklyplayground.weekly_481

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun BallPulseSyncIndicator(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "ball")
    val finalValue = -90.0f
    val animationValues = (1..3).map {
        transition.animateFloat(
            initialValue = 0.0f,
            targetValue = finalValue,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 300),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(it * 70)
            ),
            label = "ball $it"
        )
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        animationValues.forEach {
            Ball(
                modifier = Modifier
                    .padding(horizontal = 3.dp)
                    .requiredSize(50.dp)
                    .graphicsLayer {
                        translationY = it.value
                    }
            )
        }
    }

}

@Composable
private fun Ball(
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier,
        onDraw = {
            drawCircle(color = Color.LightGray)
        })
}