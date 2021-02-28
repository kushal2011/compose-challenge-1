/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PuppiesRepository
import com.example.androiddevchallenge.models.PuppyModel
import com.example.androiddevchallenge.ui.theme.MyTheme
import androidx.compose.foundation.lazy.items
import com.google.gson.Gson
import dev.chrisbanes.accompanist.coil.CoilImage

class MainActivity : AppCompatActivity() {
    var puppiesList: ArrayList<PuppyModel> = PuppiesRepository.fetchPuppies()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DisplayListOfPuppies(puppiesList = puppiesList)
                }
            }
        }
    }
}


@Composable
fun DisplayListOfPuppies(puppiesList: ArrayList<PuppyModel>) {
    LazyColumn {
        items(puppiesList) { puppy: PuppyModel ->
            PuppyListItem(puppy)
        }
    }
}

@Composable
fun PuppyListItem(puppy: PuppyModel) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .height(130.dp)
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                val intent = Intent(context, PuppyDetailsActivity::class.java)
                intent.putExtra(
                    Constants.PUPPY_DETAILS_INTENT,
                    Gson()
                        .toJson(puppy)
                        .toString()
                )
                context.startActivity(intent)
            },
        elevation = 8.dp,
        shape = RoundedCornerShape(10)
    ) {

        Row {
            CoilImage(
                data = puppy.imgUrl,
                contentDescription = "image of puppy",
                modifier = Modifier
                    .width(130.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.FillBounds,
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Name: ${puppy.name}",
                )
                Text(
                    text = "Breed: ${puppy.breed}",
                )
                Text(
                    text = Utilities.getPuppysAge(puppy.age)
                )
            }
            Spacer(Modifier.weight(1f))
            Image(
                painterResource(
                    id = if (puppy.isMale) {
                        R.drawable.ic_male
                    } else {
                        R.drawable.ic_female
                    }
                ), "", modifier = Modifier
                    .height(40.dp)
                    .padding(8.dp)
            )


        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme {
        DisplayListOfPuppies(puppiesList = PuppiesRepository.fetchPuppies())
    }
}
