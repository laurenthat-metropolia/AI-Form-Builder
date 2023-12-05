package com.draw2form.ai.presentation.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.draw2form.ai.R
import com.draw2form.ai.api.ApiUploadedFileState
import com.draw2form.ai.presentation.ui.theme.LinkUpTheme

@Composable
fun ImageProcessStatus(state: String, label: String) {

    ListItem(
        modifier = Modifier.padding(10.dp),
        headlineContent = {
            Text(text = label, textAlign = TextAlign.End, fontSize = 16.sp)
        },
        leadingContent = {
            ProcessingLottieAnimation(state)
        }
    )
}

@Composable
fun ProcessingLottieAnimation(state: String) {
    val successComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_success))
    val loadingComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_loading))
    val errorComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_error))

    LottieAnimation(
        composition = when(state) {
            "success" -> successComposition
            "error" -> errorComposition
            "loading" -> loadingComposition
            else -> loadingComposition
        },
        iterations = when(state) {
            "success" -> 1
            "error" -> 1
            "loading" -> 100
            else -> 100
        },
        modifier = Modifier.size(50.dp)
    )
}

@Composable
fun ProcessingScreen(state: ApiUploadedFileState, onEditForm: () -> Unit) {
    // val waitComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.please_wait))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Processing your image", fontSize = 20.sp)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .border(2.dp, Color.Gray, shape = RectangleShape)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
//                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageProcessStatus(state.objectRecognition, "Object Recognition")
                ImageProcessStatus(state.textRecognition, "Text Recognition")
                ImageProcessStatus(state.formGeneration, "Form Generation")
                Spacer(modifier = Modifier.height(50.dp))
                Button(
                    enabled = state.formGeneration == "success"
                            && state.textRecognition == "success"
                            && state.objectRecognition == "success",
                    onClick = {
                        onEditForm()
                    }
                ) {
                    Text(text = "View Form")
                }
                Text(
                    "Image processing might take 5-15 seconds. Please wait patiently.",
                    modifier = Modifier.padding(top = 50.dp),
                    textAlign = TextAlign.Center

                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProcessingScreenPreview() {
    LinkUpTheme {
        ProcessingScreen(ApiUploadedFileState("success", "success", "success")) {

        }
    }
}

