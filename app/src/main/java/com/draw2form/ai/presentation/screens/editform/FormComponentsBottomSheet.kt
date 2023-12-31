package com.draw2form.ai.presentation.screens.editform

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.draw2form.ai.api.ApiFormButton
import com.draw2form.ai.api.ApiFormCheckbox
import com.draw2form.ai.api.ApiFormImage
import com.draw2form.ai.api.ApiFormLabel
import com.draw2form.ai.api.ApiFormTextField
import com.draw2form.ai.api.ApiFormToggleSwitch
import com.draw2form.ai.presentation.icons.Button
import com.draw2form.ai.presentation.icons.CheckBox
import com.draw2form.ai.presentation.icons.Image
import com.draw2form.ai.presentation.icons.Label
import com.draw2form.ai.presentation.icons.TextField
import com.draw2form.ai.presentation.icons.ToggleSwitch
import com.draw2form.ai.presentation.screens.UIComponent
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormComponentsBottomSheet(onAdd: (UIComponent) -> Unit) {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    val componentList = listOf(
        Component(Icons.Filled.TextField, "Text Field"),
        Component(Icons.Filled.ToggleSwitch, "Toggle Switch"),
        Component(Icons.Filled.CheckBox, "Check Box"),
        Component(Icons.Filled.Button, "Button"),
        Component(Icons.Filled.Label, "Label"),
        Component(Icons.Filled.Image, "Image"),
    )
    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {

        ExtendedFloatingActionButton(
            onClick = { isSheetOpen = true },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
            Text(text = "Add new")
        }

    }
    if (isSheetOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSheetOpen = false

            },
        ) {
            ComponentLazyColumn(components = componentList, onAdd = {
                onAdd(it)
                Timber.d("Clicked! $it")
                isSheetOpen = false
            })
        }
    }
}


@Composable
private fun ComponentLazyColumn(
    components: List<Component>,
    modifier: Modifier = Modifier,
    onAdd: (UIComponent) -> Unit,
) {

    LazyColumn(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(components.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (component in rowItems) {
                    ComponentItem(
                        componentImage = component.componentImage,
                        text = component.text,
                        onAdd = {
                            onAdd(it)
                        })
                }

            }
        }
    }
}

data class Component(
    val componentImage: ImageVector,
    val text: String,
)

@Composable
private fun ComponentItem(
    componentImage: ImageVector,
    text: String,
    onAdd: (UIComponent) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(25.dp)
            .clickable {
                when (text) {
                    "Check Box" -> {
                        onAdd(
                            UIComponent(
                                checkbox = ApiFormCheckbox(
                                    "",
                                    "Checkbox",
                                    null,
                                    "",
                                    0,
                                    null
                                )
                            )
                        )
                    }

                    "Text Field" -> {
                        onAdd(
                            UIComponent(
                                textField = ApiFormTextField(
                                    "",
                                    null,
                                    "",
                                    "Text Field",
                                    0,
                                    null
                                )
                            )
                        )
                    }

                    "Label" -> {
                        onAdd(
                            UIComponent(
                                label = ApiFormLabel(
                                    "",
                                    null,
                                    "",
                                    0,
                                    "Label",
                                )
                            )
                        )
                    }

                    "Toggle Switch" -> {
                        onAdd(
                            UIComponent(
                                toggleSwitch = ApiFormToggleSwitch(
                                    "",
                                    "Toggle Switch",
                                    null,
                                    "",
                                    0,
                                    null
                                )
                            )
                        )
                    }

                    "Button" -> {
                        onAdd(
                            UIComponent(
                                button = ApiFormButton(
                                    "",
                                    "Button",
                                    null,
                                    "",
                                    0,
                                    ""
                                )
                            )
                        )
                    }

                    "Image" -> {
                        onAdd(
                            UIComponent(
                                image = ApiFormImage(
                                    "",
                                    null,
                                    "",
                                    0,
                                    ""
                                )
                            )
                        )
                    }
                }
            }
    ) {
        Icon(
            imageVector = componentImage,
            contentDescription = text,
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
        )
    }
}



