package com.duoc.appandroidstudioproject.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.duoc.appandroidstudioproject.model.RackModelo


@Composable
fun Accordion(
    elementoRack: RackModelo, expandidoInicial: Boolean = false
) {
    var expandido by remember { mutableStateOf(value = expandidoInicial) }
    val rotacion by animateFloatAsState(
        targetValue = if (expandido) 180f else 0f,
        label = "accordionIconRotation"
    )

    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().clickable{ expandido = !expandido }.padding( horizontal = 16.dp, vertical = 14.dp )
        ) {
            Text( text = elementoRack.id.toString() )
            Text( text = "v", modifier = Modifier.graphicsLayer{rotationZ = rotacion} )
        }
        AnimatedVisibility(
            visible = expandido,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Text( text = elementoRack.descripcion )
        }
    }
}