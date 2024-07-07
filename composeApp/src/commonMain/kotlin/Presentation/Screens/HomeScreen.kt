package Presentation.Screens

import Presentation.Components.MovieBannerSingle
import Presentation.Components.SingleCategory
import Presentation.Components.SingleShow
import Presentation.Components.textWithSeeAllText
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    Box(Modifier.fillMaxSize()) {

        val scrollState = rememberScrollState()

        Column(Modifier.fillMaxWidth().verticalScroll(scrollState)) {
            val pagerState = rememberPagerState(
                initialPage = 0,
                initialPageOffsetFraction = 0f
            ) {
                3
            }

            HorizontalPager(state = pagerState) {
                MovieBannerSingle()
            }

            textWithSeeAllText("Top movies") {

            }

            LazyRow(Modifier.fillMaxWidth()) {
                item {
                    Spacer(Modifier.padding(8.dp))
                }
                items(10) {
                    SingleShow()
                }
                item {
                    Spacer(Modifier.padding(8.dp))
                }
            }


            textWithSeeAllText("Top series") {

            }

            LazyRow(Modifier.fillMaxWidth()) {
                item {
                    Spacer(Modifier.padding(8.dp))
                }
                items(10) {
                    SingleShow()
                }
                item {
                    Spacer(Modifier.padding(8.dp))
                }
            }

            textWithSeeAllText("Category") {

            }

            Column(Modifier.fillMaxWidth().padding(10.dp, 0.dp)) {
                repeat(3) {
                    SingleCategory()
                }
            }

            textWithSeeAllText("New Releases") {

            }

            LazyRow(Modifier.fillMaxWidth()) {
                item {
                    Spacer(Modifier.padding(8.dp))
                }
                items(10) {
                    SingleShow()
                }
                item {
                    Spacer(Modifier.padding(8.dp))
                }
            }

            textWithSeeAllText("For you") {

            }

            LazyRow(Modifier.fillMaxWidth()) {
                item {
                    Spacer(Modifier.padding(8.dp))
                }
                items(10) {
                    SingleShow()
                }
                item {
                    Spacer(Modifier.padding(8.dp))
                }
            }

            Spacer(Modifier.padding(50.dp))

        }
    }
}


