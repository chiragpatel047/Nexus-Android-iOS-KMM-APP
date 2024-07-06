package Presentation.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import nexus.composeapp.generated.resources.Res
import nexus.composeapp.generated.resources.temp_movie_banner
import org.jetbrains.compose.resources.painterResource

@Composable
fun SingleShow() {
    Box(Modifier.clip(RoundedCornerShape(25.dp)).padding(5.dp)) {
        Image(
            painter = painterResource(Res.drawable.temp_movie_banner),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.width(150.dp).height(200.dp).clip(RoundedCornerShape(25.dp))
        )
        Box(Modifier.align(Alignment.TopStart).padding(10.dp)) {
            SmallRatingWithText("9.2")
        }
    }
}