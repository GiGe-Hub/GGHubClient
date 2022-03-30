package com.sophimp.gghub.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.sophimp.gghub.ui.bean.TabDataBean
import com.sophimp.gghub.ui.bean.homeTabs
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomTabWithPager(tabDatas: List<TabDataBean>) {
    val pagerState = rememberPagerState(
        initialPage = 1,
    )
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column {
        HorizontalPager(
            count = tabDatas.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { index ->
            tabDatas[index].page()

        }

        TabRow(
            selectedTabIndex = tabIndex,
//        indicator = { tabPositions ->
//            TabRowDefaults.Indicator(
//                Modifier.tabIndicatorOffset(tabPositions[tabIndex])
//            )
//        }
            Modifier
                .height(60.dp)
                .fillMaxWidth()
        ) {
            tabDatas.forEachIndexed { index, tabData ->
                Tab(
                    selected = tabIndex == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = stringResource(id = tabData.nameRes))
                    }, icon = {
                        Icon(
                            painterResource(id = tabData.iconResId),
                            "",
                            Modifier
                                .width(24.dp)
                                .height(24.dp)
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun TabWithPagerPreview() {
    BottomTabWithPager(homeTabs)
}