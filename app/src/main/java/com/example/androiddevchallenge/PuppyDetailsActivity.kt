package com.example.androiddevchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.models.PuppyModel
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.google.gson.Gson
import dev.chrisbanes.accompanist.coil.CoilImage

class PuppyDetailsActivity : AppCompatActivity() {

    private lateinit var puppyDetails: PuppyModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent.hasExtra(Constants.PUPPY_DETAILS_INTENT)) {
            val gson = Gson()
            puppyDetails = gson.fromJson(
                intent.extras!!.get(Constants.PUPPY_DETAILS_INTENT).toString(),
                PuppyModel::class.java
            )
        } else {
            onBackPressed()
        }
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PuppyDetails(puppyDetails)
                }
            }
        }
    }
}

@Composable
fun PuppyDetails(puppy: PuppyModel) {
    val context = LocalContext.current
    Column {
        CoilImage(
            data = puppy.imgUrl,
            contentDescription = "image of puppy",
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillBounds,
        )
        Text(
            text = puppy.name,
            style = (MaterialTheme.typography).body1
                .merge(TextStyle(fontSize = 25.sp, color = Color.Gray)),
            modifier = Modifier
                .padding(8.dp)
        )
        val gender: String = if (puppy.isMale) {
            "Male"
        } else {
            "Female"
        }
        Text(
            text = "Gender : $gender",
            style = (MaterialTheme.typography).body1
                .merge(TextStyle(fontSize = 20.sp)),
            modifier = Modifier
                .padding(8.dp)
        )
        Text(
            text = "Age : ${Utilities.getPuppysAge(puppy.age)}",
            style = (MaterialTheme.typography).body1
                .merge(TextStyle(fontSize = 20.sp)),
            modifier = Modifier
                .padding(8.dp)
        )
        Text(
            text = "${puppy.name} is a $gender ${puppy.breed} of age ${Utilities.getPuppysAge(puppy.age)} , He loves dog food and is very friendly he is looking for a best fiend... He is a good boi , will you like to adpot him...?",
            style = (MaterialTheme.typography).body1
                .merge(TextStyle(fontSize = 15.sp)),
            modifier = Modifier
                .padding(8.dp)
        )
        Spacer(Modifier.weight(1f))
        Button(
            onClick = {
                Toast.makeText(context, "Adopted", Toast.LENGTH_LONG).show()
            }, modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(0)
        ) {
            Text(text = "Adopt ${puppy.name} <3")
        }
    }


}
