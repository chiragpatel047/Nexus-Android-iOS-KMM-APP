package Presentation.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nexus.composeapp.generated.resources.Res
import nexus.composeapp.generated.resources.poppins_medium
import nexus.composeapp.generated.resources.temp_movie_banner
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun MovieBannerSingle() {
    Box(Modifier.fillMaxWidth()) {

        val gradientBrush = Brush.verticalGradient(
            colors = listOf(Color.Transparent, Color(0xB3000000)), // Gradient colors
            startY = 0f, // Starting Y position of the gradient
            endY = 1800f // Ending Y position of the gradient
        )

        Image(
            painter = painterResource(Res.drawable.temp_movie_banner),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().height(350.dp)
        )
        Box(modifier = Modifier.fillMaxWidth().height(350.dp).background(gradientBrush))
        Column(Modifier.fillMaxWidth().align(Alignment.BottomStart).padding(20.dp)) {
            Text(
                text = "Dr. Strange 2",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(Res.font.poppins_medium))
            )
            Text(
                text = "Action, Superhero, Science Fiction...",
                fontSize = 12.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(Res.font.poppins_medium))
            )
            Spacer(Modifier.padding(5.dp))
            Row {
                PrimaryRatingWithText("8.9")
                Spacer(Modifier.padding(5.dp))
                PrimarySaveWithText(false)
            }

        }
    }
}