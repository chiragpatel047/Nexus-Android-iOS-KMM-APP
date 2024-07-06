package Presentation.Screens

import Presentation.ViewModel.HomeViewModel
import androidx.lifecycle.ViewModel
import nexus.composeapp.generated.resources.Res
import nexus.composeapp.generated.resources.poppins_medium
import nexus.composeapp.generated.resources.user
import org.koin.compose.currentKoinScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavController.OnDestinationChangedListener
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nexus.composeapp.generated.resources.bookmark
import nexus.composeapp.generated.resources.home
import nexus.composeapp.generated.resources.search
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {

    Column(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {

        val homeViewModel = koinViewModel<HomeViewModel>()
        val showListResult by homeViewModel.showListResult.collectAsState()

        var currentNavScreen = remember { mutableStateOf("") }
        var isBottomBarShowing = remember {
            mutableStateOf(true)
        }

        Column(Modifier.fillMaxWidth().weight(1f)) {
            NavHost(navController, startDestination = "HomeScreen") {
                composable("HomeScreen") {
                    isBottomBarShowing.value = true
                    currentNavScreen.value = "HomeScreen"
                    HomeScreen(navController)
                }
                composable("SearchScreen") {
                    isBottomBarShowing.value = true
                    currentNavScreen.value = "SearchScreen"
                    SearchScreen(navController)
                }

                composable("SavedScreen") {
                    isBottomBarShowing.value = true
                    currentNavScreen.value = "SavedScreen"
                    SavedScreen(navController)
                }
                composable("ProfileScreen") {
                    isBottomBarShowing.value = true
                    currentNavScreen.value = "ProfileScreen"
                    ProfileScreen(navController)
                }
//                composable("DMScreen") {
//                    isBottomBarShowing.value = false
//                    currentNavScreen.value = "DMScreen"
//                    DMScreen(navController)
//                }
            }
        }

        AnimatedVisibility(isBottomBarShowing.value) {
            Row(
                Modifier.fillMaxWidth()
                    .shadow(20.dp, RoundedCornerShape(0.dp), true, Color.Black)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(0.dp, 15.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable {
                        if (!currentNavScreen.equals("HomeScreen")) {
                            currentNavScreen.value = "HomeScreen"
                            navController.navigate("HomeScreen") {
                                launchSingleTop = true
                                popUpTo("HomeScreen")
                            }
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.home),
                        tint = if (currentNavScreen.value.equals("HomeScreen")) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        text = "Home",
                        color = if (currentNavScreen.value.equals("HomeScreen")) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(Res.font.poppins_medium))
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable {
                        if (!currentNavScreen.equals("SearchScreen")) {
                            currentNavScreen.value = "SearchScreen"
                            navController.navigate("SearchScreen") {
                                launchSingleTop = true
                                popUpTo("SearchScreen")
                            }
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.search),
                        tint = if (currentNavScreen.value.equals("SearchScreen")) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        text = "Search",
                        color = if (currentNavScreen.value.equals("SearchScreen")) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(Res.font.poppins_medium))
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable {
                        if (!currentNavScreen.equals("SavedScreen")) {
                            currentNavScreen.value = "SavedScreen"
                            navController.navigate("SavedScreen") {
                                launchSingleTop = true
                                popUpTo("SavedScreen")
                            }
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.bookmark),
                        tint = if (currentNavScreen.value.equals("SavedScreen")) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        text = "Saved",
                        color = if (currentNavScreen.value.equals("SavedScreen")) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(Res.font.poppins_medium))
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable {
                        if (!currentNavScreen.equals("ProfileScreen")) {
                            currentNavScreen.value = "ProfileScreen"
                            navController.navigate("ProfileScreen") {
                                launchSingleTop = true
                                popUpTo("ProfileScreen")
                            }
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.user),
                        tint = if (currentNavScreen.value.equals("ProfileScreen")) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        text = "Profile",
                        color = if (currentNavScreen.value.equals("ProfileScreen")) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(Res.font.poppins_medium))
                    )
                }
            }
        }
    }
}


@Composable
inline fun <reified T : ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}