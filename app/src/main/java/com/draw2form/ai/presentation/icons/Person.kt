package com.draw2form.ai.presentation.icons

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Filled.Person: ImageVector
    get() {
        if (_personFill0Wght400Grad0Opsz24 != null) {
            return _personFill0Wght400Grad0Opsz24!!
        }
        _personFill0Wght400Grad0Opsz24 = Builder(
            name = "PersonFill0Wght400Grad0Opsz24",
            defaultWidth = 24.0.dp, defaultHeight = 24.0.dp, viewportWidth = 960.0f,
            viewportHeight = 960.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(480.0f, 480.0f)
                quadToRelative(-66.0f, 0.0f, -113.0f, -47.0f)
                reflectiveQuadToRelative(-47.0f, -113.0f)
                quadToRelative(0.0f, -66.0f, 47.0f, -113.0f)
                reflectiveQuadToRelative(113.0f, -47.0f)
                quadToRelative(66.0f, 0.0f, 113.0f, 47.0f)
                reflectiveQuadToRelative(47.0f, 113.0f)
                quadToRelative(0.0f, 66.0f, -47.0f, 113.0f)
                reflectiveQuadToRelative(-113.0f, 47.0f)
                close()
                moveTo(160.0f, 800.0f)
                verticalLineToRelative(-112.0f)
                quadToRelative(0.0f, -34.0f, 17.5f, -62.5f)
                reflectiveQuadTo(224.0f, 582.0f)
                quadToRelative(62.0f, -31.0f, 126.0f, -46.5f)
                reflectiveQuadTo(480.0f, 520.0f)
                quadToRelative(66.0f, 0.0f, 130.0f, 15.5f)
                reflectiveQuadTo(736.0f, 582.0f)
                quadToRelative(29.0f, 15.0f, 46.5f, 43.5f)
                reflectiveQuadTo(800.0f, 688.0f)
                verticalLineToRelative(112.0f)
                lineTo(160.0f, 800.0f)
                close()
                moveTo(240.0f, 720.0f)
                horizontalLineToRelative(480.0f)
                verticalLineToRelative(-32.0f)
                quadToRelative(0.0f, -11.0f, -5.5f, -20.0f)
                reflectiveQuadTo(700.0f, 654.0f)
                quadToRelative(-54.0f, -27.0f, -109.0f, -40.5f)
                reflectiveQuadTo(480.0f, 600.0f)
                quadToRelative(-56.0f, 0.0f, -111.0f, 13.5f)
                reflectiveQuadTo(260.0f, 654.0f)
                quadToRelative(-9.0f, 5.0f, -14.5f, 14.0f)
                reflectiveQuadToRelative(-5.5f, 20.0f)
                verticalLineToRelative(32.0f)
                close()
                moveTo(480.0f, 400.0f)
                quadToRelative(33.0f, 0.0f, 56.5f, -23.5f)
                reflectiveQuadTo(560.0f, 320.0f)
                quadToRelative(0.0f, -33.0f, -23.5f, -56.5f)
                reflectiveQuadTo(480.0f, 240.0f)
                quadToRelative(-33.0f, 0.0f, -56.5f, 23.5f)
                reflectiveQuadTo(400.0f, 320.0f)
                quadToRelative(0.0f, 33.0f, 23.5f, 56.5f)
                reflectiveQuadTo(480.0f, 400.0f)
                close()
                moveTo(480.0f, 320.0f)
                close()
                moveTo(480.0f, 720.0f)
                close()
            }
        }
            .build()
        return _personFill0Wght400Grad0Opsz24!!
    }

private var _personFill0Wght400Grad0Opsz24: ImageVector? = null
