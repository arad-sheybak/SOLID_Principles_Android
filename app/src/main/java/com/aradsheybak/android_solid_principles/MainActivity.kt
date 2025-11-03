package com.aradsheybak.android_solid_principles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aradsheybak.android_solid_principles.ui.theme.Android_Solid_PrinciplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_Solid_PrinciplesTheme {

            }
        }
    }
}

