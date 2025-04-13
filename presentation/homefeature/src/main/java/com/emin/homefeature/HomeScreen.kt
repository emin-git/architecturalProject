package com.emin.homefeature

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.emin.basefeature.components.BannerCard
import com.emin.moviesfeature.navigation.navigateMoviesScreen
import com.emin.presentation.basefeature.R as BaseR

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun HomeScreen(navController: NavHostController) {

    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .padding(10.dp)
                .background(Color.Transparent)
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BannerCard(
                title = stringResource(BaseR.string.movie),
                stringResource(BaseR.string.description),
                BaseR.drawable.bannermovie,
                Modifier.weight(1f),
                onClick = {
                    navController.navigateMoviesScreen()
                }
            )
            BannerCard(
                title = stringResource(BaseR.string.music),
                stringResource(BaseR.string.description),
                BaseR.drawable.bannermusic,
                Modifier.weight(1f),
                onClick = {
                    val intent =
                        Intent(context, Class.forName("com.emin.supermusic.MainActivity"))
                    context.startActivity(intent)
                }
            )
        }
    }
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}