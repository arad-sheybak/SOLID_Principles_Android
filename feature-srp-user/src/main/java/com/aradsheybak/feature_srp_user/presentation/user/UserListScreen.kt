package com.aradsheybak.feature_srp_user.presentation.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.aradsheybak.feature_srp_user.core.domain.entity.User
import com.aradsheybak.feature_srp_user.presentation.user.contract.UserListIntent
import com.aradsheybak.feature_srp_user.presentation.user.contract.UserListSideEffect
import com.aradsheybak.feature_srp_user.presentation.user.contract.UserListState

@Composable
fun UserListScreen(
    viewModel: UserListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val sideEffect by viewModel.sideEffect.collectAsState(initial = null)

    // Handle Side Effects
    LaunchedEffect(key1 = sideEffect) {
        sideEffect?.let { effect ->
            when (effect) {
                is UserListSideEffect.ShowToast -> {
                    // Toast نمایش بده
                }
                is UserListSideEffect.NavigateToUserDetail -> {
                    // Navigation انجام بده
                }
            }
        }
    }

    // Handle Initial Load
    LaunchedEffect(Unit) {
        viewModel.processIntent(UserListIntent.LoadUsers)
    }

    UserListContent(
        state = state,
        onIntent = viewModel::processIntent
    )
}

@Composable
fun UserListContent(
    state: UserListState,
    onIntent: (UserListIntent) -> Unit
) {
    when {
        state.isLoading -> LoadingScreen()
        state.error != null -> ErrorScreen(
            error = state.error,
            onRetry = { onIntent(UserListIntent.Retry) }
        )
        else -> UserList(
            users = state.users,
            onUserClick = { user -> onIntent(UserListIntent.UserClicked(user)) }
        )
    }
}

@Composable
fun UserList(
    users: List<User>,
    onUserClick: (User) -> Unit
) {
    LazyColumn {
        items(users) { user ->
            UserItem(
                user = user,
                onClick = { onUserClick(user) }
            )
        }
    }
}

@Composable
fun UserItem(
    user: User,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = user.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = user.email,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Text(
                text = if (user.isActive) "Active" else "Inactive",
                color = if (user.isActive) Color.Green else Color.Red,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(
    error: String,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Error: $error", color = Color.Red)
        LocalDensity
        Button(
            onClick = onRetry,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Retry")
        }
    }
}