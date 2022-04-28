package com.sophimp.gghub.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sophimp.gghub.R
import com.sophimp.gghub.ui.bean.RepositoryUIBean
import com.sophimp.gghub.ui.theme.PaddingStartEnd

/**
 * repository card
 * @author sfx
 * @date 2022/4/28
 */
@Composable
@Preview
fun RepositoryCardPreview() {
    RepositoryCard(repositoryUIBean = RepositoryUIBean("rich-text", 6, "kotlin", "kotlin"))
}

@Composable
fun RepositoryCard(repositoryUIBean: RepositoryUIBean) {
    Card() {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(PaddingStartEnd, 0.dp, PaddingStartEnd, 0.dp)
                .wrapContentHeight()
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_repo),
                    contentDescription = "repo"
                )
                Text(text = repositoryUIBean.name)
            }
            Text(
                text = repositoryUIBean.description,
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(10.dp)
                        .height(10.dp)
                        .background(color = Color.Blue, shape = CircleShape)
                )
                Text(
                    text = repositoryUIBean.language ?: "", modifier = Modifier
                        .padding(5.dp, 0.dp, 0.dp, 0.dp)
                        .wrapContentWidth()
                        .wrapContentHeight()
                )

                Box(
                    modifier = Modifier
                        .padding(5.dp, 0.dp, 0.dp, 0.dp)
                        .width(10.dp)
                        .height(10.dp)
                        .background(color = Color.Blue, shape = CircleShape)
                )
                Text(
                    text = "${repositoryUIBean.stars}" ?: "", modifier = Modifier
                        .padding(5.dp, 0.dp, 0.dp, 0.dp)
                        .wrapContentWidth()
                        .wrapContentHeight()
                )

            }
        }
    }
}