package com.aradsheybak.android_solid_principles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aradsheybak.android_solid_principles.ui.theme.Android_Solid_PrinciplesTheme
import com.aradsheybak.feature_srp_user.presentation.user.UserListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_Solid_PrinciplesTheme {
                UserListScreen()

            }
        }
    }
}

