package com.aradsheybak.feature_srp_user.presentation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aradsheybak.feature_srp_user.core.domain.entity.User
import com.aradsheybak.feature_srp_user.core.domain.usecase.GetUsersUseCase
import com.aradsheybak.feature_srp_user.presentation.user.contract.UserListIntent
import com.aradsheybak.feature_srp_user.presentation.user.contract.UserListSideEffect
import com.aradsheybak.feature_srp_user.presentation.user.contract.UserListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(UserListState())
    val state: StateFlow<UserListState> = _state.asStateFlow()

    private val _sideEffect = Channel<UserListSideEffect>()
    val sideEffect = _sideEffect.receiveAsFlow()

    fun processIntent(intent: UserListIntent) {
        when (intent) {
            UserListIntent.LoadUsers -> loadUsers()
            UserListIntent.Retry -> loadUsers()
            is UserListIntent.UserClicked -> onUserClicked(intent.user)
        }
    }

    private fun loadUsers() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            try {
                val users = getUsersUseCase()
                _state.update { it.copy(users = users, isLoading = false) }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Failed to load users"
                    )
                }
                _sideEffect.send(UserListSideEffect.ShowToast("Failed to load users"))
            }
        }
    }

    private fun onUserClicked(user: User) {
        viewModelScope.launch {
            _sideEffect.send(UserListSideEffect.NavigateToUserDetail(user.id))
        }
    }
}