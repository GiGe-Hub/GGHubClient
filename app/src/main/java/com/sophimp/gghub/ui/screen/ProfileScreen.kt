package com.sophimp.gghub.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sophimp.gghub.R
import com.sophimp.gghub.ui.bean.PersonalInfo

/**
 * create by sfx on 2022/3/30 13:39
 */
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val personalInfo = PersonalInfo(
            "张三", "", "Sophisticate & Simple",
            "xxx@163.com", "http://xxxx",
            39, 299
        )
        ProfileTopBar(personalInfo)
    }
}

@Composable
fun ProfileTopBar(personalInfo: PersonalInfo) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                modifier = Modifier
                    .width(56.dp)
                    .height(56.dp),
                contentDescription = ""
            )

            Column(
                Modifier
                    .weight(1.5f)
                    .fillMaxHeight()
            ) {
                Text(text = "名字")
                Text(text = "别名j")
            }
            Row(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Column(
                    Modifier
                        .wrapContentHeight()
                        .wrapContentWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "followers")
                    Text(text = "${personalInfo.followers}")
                }
                Column(
                    Modifier
                        .padding(5.dp, 0.dp, 0.dp, 0.dp)
                        .wrapContentHeight()
                        .wrapContentWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "following")
                    Text(text = "${personalInfo.followings}")
                }
            }
        }

        Text(
            text = personalInfo.email,
            Modifier
                .wrapContentWidth()
                .wrapContentHeight()
        )
        Text(
            text = personalInfo.blog,
            Modifier
                .wrapContentWidth()
                .wrapContentHeight()
        )
    }
}

@Composable
@Preview
fun PreviewProfile() {
    ProfileScreen()
}