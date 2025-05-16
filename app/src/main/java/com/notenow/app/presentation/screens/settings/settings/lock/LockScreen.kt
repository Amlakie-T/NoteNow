
package com.notenow.app.presentation.screens.settings.settings.lock

import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.notenow.app.presentation.components.NotesScaffold
import com.notenow.app.presentation.navigation.ActionType
import com.notenow.app.presentation.screens.settings.model.SettingsViewModel
import com.notenow.app.presentation.screens.settings.settings.lock.components.FingerprintLock
import com.notenow.app.presentation.screens.settings.settings.lock.components.PasscodeLock
import com.notenow.app.presentation.screens.settings.settings.lock.components.PatternLock

@Composable
fun LockScreen(
    settingsViewModel: SettingsViewModel,
    navController: NavController,
    action: ActionType?,
) {
    NotesScaffold {
        if (action != null) {
            when (action) {
                ActionType.PASSCODE -> PasscodeLock(settingsViewModel, navController)
                ActionType.FINGERPRINT -> FingerprintLock(settingsViewModel = settingsViewModel, navController = navController)
                ActionType.PATTERN -> PatternLock(settingsViewModel = settingsViewModel, navController = navController)
            }
        } else {
            when {
                settingsViewModel.settings.value.pattern != null -> PatternLock(settingsViewModel = settingsViewModel, navController = navController)
                settingsViewModel.settings.value.fingerprint -> FingerprintLock(settingsViewModel = settingsViewModel, navController = navController)
                settingsViewModel.settings.value.passcode != null -> PasscodeLock(settingsViewModel, navController)
            }
        }
    }
}