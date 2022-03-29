package com.sophimp.gghub.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.sophimp.gghub.ui.bean.homeTabs
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabWithPager() {
    val pagerState = rememberPagerState(
        initialPage = 1,
    )
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column {
        HorizontalPager(
            count = homeTabs.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { index ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = homeTabs[index].nameRes),
                )
            }
        }
    }

    TabRow(
        selectedTabIndex = tabIndex,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabPositions[0])
            )
        }
    ) {
        homeTabs.forEachIndexed { index, pair ->
            Tab(selected = tabIndex == index, onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }, text = {
                Text(text = stringResource(id = pair.nameRes))
            }, /*icon = {
                    Icon(imageVector = pair.iconResId, contentDescription = null)
                }*/
            )
        }
    }
}

@Preview
@Composable
fun TabWithPagerPreview() {
    TabWithPager()
}