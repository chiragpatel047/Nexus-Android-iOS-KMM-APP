package Presentation.Screens

import Presentation.Components.SavedSingleShow
import Presentation.Components.SingleGridShow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import nexus.composeapp.generated.resources.Res
import nexus.composeapp.generated.resources.poppins_medium
import org.jetbrains.compose.resources.Font

@Composable
fun SavedScreen(navController: NavController) {
    Box(
        Modifier.fillMaxSize().background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color.Transparent,
                    Color.Black.copy(alpha = 0.1f)
                ),
                startY = 0f,
                endY = 400.0f
            )
        )
    ) {
        Column(Modifier.fillMaxWidth()) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(15.dp, 0.dp)
            ) {
                items(2) {
                    Spacer(Modifier.padding(35.dp))
                }
                items(20) {
                    SavedSingleShow()
                }
                items(2) {
                    Spacer(Modifier.padding(50.dp))
                }
            }
        }

        Column(
            Modifier.fillMaxWidth().align(Alignment.TopCenter)
                .background(MaterialTheme.colorScheme.background.copy(alpha = 0.9f)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "My saved",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(Res.font.poppins_medium)),
                modifier = Modifier.padding(15.dp)
            )
        }
    }


}