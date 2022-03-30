package com.sophimp.gghub.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sophimp.gghub.R

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

        ProfileTopBar()

        Text(
            text = "profile"
        )
    }
}

@Composable
fun ProfileTopBar() {
    Row(
        modifier = Modifier
            .height(46.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher),
            contentDescription = ""
        )

    }
}

@Preview
@Composable
fun ProfilePreView() {
    ProfileScreen()
}