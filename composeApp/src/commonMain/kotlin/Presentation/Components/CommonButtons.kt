package Presentation.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nexus.composeapp.generated.resources.Res
import nexus.composeapp.generated.resources.bookmark
import nexus.composeapp.generated.resources.fill_bookmark
import nexus.composeapp.generated.resources.poppins_medium
import nexus.composeapp.generated.resources.star
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun PrimaryRatingWithText(rating: String) {
    Row(
        Modifier.clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.primary),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            Modifier.padding(15.dp, 1.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(Res.drawable.star),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(15.dp)
            )
            Spacer(Modifier.padding(4.dp))
            Text(
                text = rating,
                fontSize = 12.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(Res.font.poppins_medium)),
                modifier = Modifier.padding(0.dp, 2.dp, 0.dp, 0.dp)
            )
        }

    }
}

@Composable
fun SmallRatingWithText(rating: String) {
    Row(
        Modifier.clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.primary),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            Modifier.padding(10.dp, 0.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(Res.drawable.star),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(10.dp)
            )
            Spacer(Modifier.padding(2.dp))
            Text(
                text = rating,
                fontSize = 10.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(Res.font.poppins_medium)),
                modifier = Modifier.padding(0.dp, 2.dp, 0.dp, 0.dp)
            )
        }

    }
}

@Composable
fun PrimarySaveWithText(isSaved: Boolean) {
    Row(
        Modifier.clip(RoundedCornerShape(25.dp))
            .border(1.dp, Color.White, RoundedCornerShape(25.dp)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            Modifier.padding(15.dp, 1.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(if (isSaved) Res.drawable.fill_bookmark else Res.drawable.bookmark),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(15.dp)
            )
            Spacer(Modifier.padding(4.dp))
            Text(
                text = if (isSaved) "Saved" else "Save",
                fontSize = 12.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(Res.font.poppins_medium))
            )
        }
    }
}