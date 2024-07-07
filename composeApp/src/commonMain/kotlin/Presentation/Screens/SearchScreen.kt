package Presentation.Screens

import Presentation.Components.SingleCategory
import Presentation.Components.SingleGridShow
import Presentation.Components.SingleShow
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import nexus.composeapp.generated.resources.Res
import nexus.composeapp.generated.resources.poppins_medium
import nexus.composeapp.generated.resources.search
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {
    Box(Modifier.fillMaxSize()) {

        val searchText = remember {
            mutableStateOf("")
        }
        val isSearching = remember {
            mutableStateOf(false)
        }

        Column(Modifier.fillMaxWidth()) {
            SearchBar(
                query = searchText.value,//text showed on SearchBar
                onQueryChange = {
                    searchText.value = it
                }, //update the value of searchText
                onSearch = {
                    searchText.value = it
                }, //the callback to be invoked when the input service triggers the ImeAction.Search action
                active = isSearching.value, //whether the user is searching or not
                onActiveChange = {
//                isSearching.value = !isSearching.value
//                if (!isSearching.value) {
//                    searchText.value = ""
//                }
                }, //the callback to be invoked when this search bar's active state is changed
                placeholder = {
                    Text(
                        text = "Search...",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.outline,
                        fontFamily = FontFamily(Font(Res.font.poppins_medium)),
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(Res.drawable.search),
                        tint = MaterialTheme.colorScheme.outline,
                        contentDescription = "Search icon",
                        modifier = Modifier.size(18.dp)
                    )
                },
                trailingIcon = {
                    if (isSearching.value) {
                        Icon(
                            modifier = Modifier.clickable {
                                if (searchText.value.isNotEmpty()) {
                                    searchText.value = ""
                                } else {
                                    isSearching.value = false
                                }
                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close icon"
                        )
                    }
                },

                colors = SearchBarDefaults.colors(containerColor = MaterialTheme.colorScheme.surfaceContainerHigh),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(25.dp))
            ) {

            }

            val list = listOf("All", "Movies", "Series", "Top rated", "New")
            val selectedIndex = searchChips(list)

            Spacer(Modifier.padding(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(15.dp, 0.dp)
            ) {
                items(20) {
                    SingleGridShow()
                }
                item {
                    Spacer(Modifier.padding(50.dp))
                }
            }

        }
    }
}

@Composable
fun searchChips(list: List<String>): Int {
    var selectedIndex by remember { mutableStateOf(0) }
    val horizontalScroll = rememberScrollState()
    Row(Modifier.fillMaxWidth().horizontalScroll(horizontalScroll)) {
        Spacer(Modifier.padding(8.dp))
        list.forEachIndexed { index, it ->
            FilterChip(
                onClick = {
                    selectedIndex = index
                },
                shape = RoundedCornerShape(25.dp),
                label = {
                    Text(
                        text = it,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(Res.font.poppins_medium)),
                    )
                },
                selected = if (index.equals(selectedIndex)) true else false,
                modifier = Modifier.padding(5.dp, 0.dp)
            )
        }
        Spacer(Modifier.padding(8.dp))
    }

    return selectedIndex
}
