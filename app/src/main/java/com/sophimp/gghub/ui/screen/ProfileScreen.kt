package com.sophimp.gghub.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sophimp.gghub.R
import com.sophimp.gghub.ui.bean.PersonalInfo

/**
 * create by sfx on 2022/3/30 13:39
 */
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        val personalInfo = PersonalInfo(
            "张三", "", "Sophisticate & Simple",
            "songfangxi2012@163.com", "http://sophimp.github.io",
            39, 299
        )
        ProfileTopBar(personalInfo)
    }
}

@Composable
fun ProfileTopBar(personalInfo: PersonalInfo) {
    Column(
        Modifier
            .padding(12.dp, 0.dp, 12.dp, 0.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .padding(0.dp, 12.dp, 0.dp, 12.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp),
                contentDescription = ""
            )

            Column(
                Modifier
                    .weight(1f)
                    .height(60.dp)
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
            }
            Row(
                Modifier
                    .weight(0.818f)
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    Modifier
                        .weight(1f)
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "followers")
                    Text(text = "${personalInfo.followers}", fontSize = 16.sp)
                }
                Column(
                    Modifier
                        .padding(5.dp, 0.dp, 0.dp, 0.dp)
                        .wrapContentHeight()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "following")
                    Text(text = "${personalInfo.followings}", fontSize = 16.sp)
                }
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