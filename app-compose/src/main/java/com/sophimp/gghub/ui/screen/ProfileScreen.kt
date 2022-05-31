@file:OptIn(ExperimentalFoundationApi::class)

package com.sophimp.gghub.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sophimp.gghub.R
import com.sophimp.gghub.ui.bean.PersonalUIBean
import com.sophimp.gghub.ui.bean.RepositoryUIBean
import com.sophimp.gghub.ui.theme.FontSizeTitle
import com.sophimp.gghub.ui.theme.PaddingStartEnd
import com.sophimp.gghub.ui.widget.RepositoryCard

/**
 * create by sfx on 2022/3/30 13:39
 */
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        val personalInfo = PersonalUIBean(
            "张三", "", "Sophisticate & Simple",
            "songfangxi2012@163.com", "http://sophimp.github.io",
            39, 299
        )
        ProfileTopBar(personalInfo)

        LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
            item {
                RepositoryCard(
                    repositoryUIBean = RepositoryUIBean(
                        "rich-text",
                        6,
                        "kotlin",
                        "kotlin"
                    )
                )
            }
            item {
                RepositoryCard(
                    repositoryUIBean = RepositoryUIBean(
                        "rich-text",
                        6,
                        "kotlin",
                        "kotlin"
                    )
                )
            }
        })


    }
}

@Composable
fun ButtonItemRect(name: String, iconRes: Int, count: Long) {
    Column(
        Modifier
            .height(50.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = name, fontSize = FontSizeTitle)
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(painter = painterResource(id = iconRes), contentDescription = "")
            Text(text = "$count")
        }
    }

}

@Composable
fun ProfileTopBar(personalInfo: PersonalUIBean) {
    Column(
        Modifier
            .padding(PaddingStartEnd, 0.dp, PaddingStartEnd, 0.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .padding(0.dp, PaddingStartEnd, 0.dp, PaddingStartEnd)
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp),
                contentDescription = ""
            )

            Column(
                Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .padding(8.dp, 0.dp, 0.dp, 0.dp)
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Sophimp", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "sophimp",
                    Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp),
                    fontSize = 13.sp,
                    color = Color.Gray
                )
                Button(
                    onClick = {},
                    Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp),
                ) {
                    Text(text = "Follow")
                }
            }
            Column(
                Modifier
                    .weight(0.818f)
                    .wrapContentHeight()
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(Modifier.fillMaxWidth()) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_follower),
                            contentDescription = ""
                        )
                        Text(
                            text = "followers", maxLines = 1,
                            modifier = Modifier.padding(3.dp, 0.dp, 0.dp, 0.dp)
                        )
                    }
                    Text(text = "${personalInfo.followers}", fontSize = 16.sp)
                }
                Column(
                    Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(Modifier.fillMaxWidth()) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_following),
                            contentDescription = ""
                        )
                        Text(
                            text = "following",
                            maxLines = 1,
                            modifier = Modifier.padding(3.dp, 0.dp, 0.dp, 0.dp)
                        )
                    }
                    Text(text = "${personalInfo.followings}", fontSize = 16.sp)
                }
            }
        }

        Text(text = "Sophisticate & Simple")

        Row(
            Modifier
                .padding(0.dp, 8.dp, 0.dp, 0.dp)
                .fillMaxWidth()
                .wrapContentWidth()
        ) {
            Row(
                Modifier
                    .weight(1f)
                    .wrapContentHeight()
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_email,
                    ),
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    contentDescription = ""
                )
                Text(
                    text = personalInfo.email ?: "",
                    Modifier
                        .padding(5.dp, 0.dp, 0.dp, 0.dp)
                        .wrapContentWidth()
                        .wrapContentHeight(),
                )
            }
            Row(
                Modifier
                    .weight(0.618f)
                    .padding(5.dp, 0.dp, 0.dp, 0.dp)
                    .wrapContentHeight()
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_origanization,
                    ),
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    contentDescription = ""
                )
                Text(
                    text = personalInfo.organization ?: "",
                    Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                )
            }
        }
        Row(
            Modifier
                .padding(0.dp, 8.dp, 0.dp, 0.dp)
                .fillMaxWidth()
                .wrapContentWidth()
        ) {
            Row(
                Modifier
                    .weight(1f)
                    .wrapContentHeight()
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_link,
                    ),
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    contentDescription = ""
                )
                Text(
                    text = personalInfo.link ?: "",
                    Modifier
                        .padding(5.dp, 0.dp, 0.dp, 0.dp)
                        .wrapContentWidth()
                        .wrapContentHeight(),
                )
            }
            Row(
                Modifier
                    .padding(5.dp, 0.dp, 0.dp, 0.dp)
                    .weight(0.618f)
                    .wrapContentHeight()
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_location,
                    ),
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    contentDescription = ""
                )
                Text(
                    text = personalInfo.location ?: "",
                    Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewProfile() {
    ProfileScreen()
}