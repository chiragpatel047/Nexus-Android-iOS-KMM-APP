package Presentation.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nexus.composeapp.generated.resources.Res
import nexus.composeapp.generated.resources.poppins_medium
import nexus.composeapp.generated.resources.temp_movie_banner
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun SingleCategory() {
    Box() {
        Image(
            painter = painterResource(Res.drawable.temp_movie_banner),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().height(100.dp).clip(RoundedCornerShape(25.dp))
        )
        Box(Modifier.align(Alignment.BottomEnd).padding(10.dp)) {
            Text(
                text = "SCI-FI",
                fontSize = 12.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(Res.font.poppins_medium)),
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}