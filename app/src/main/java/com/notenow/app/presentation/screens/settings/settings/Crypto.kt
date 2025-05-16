package com.notenow.app.presentation.screens.settings.settings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.notenow.app.R
import com.notenow.app.core.constant.SupportConst
import com.notenow.app.presentation.screens.settings.SettingsScaffold
import com.notenow.app.presentation.screens.settings.model.SettingsViewModel
import com.notenow.app.presentation.screens.settings.widgets.ActionType
import com.notenow.app.presentation.screens.settings.widgets.SettingsBox

@Composable
fun SupportScreen(navController: NavController, settingsViewModel: SettingsViewModel) {
    SettingsScaffold(
        settingsViewModel = settingsViewModel,
        title = stringResource(id = R.string.cryptocurrency),
        onBackNavClicked = { navController.navigateUp() }
    ) {
        LazyColumn {
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = "Bitcoin (BTC)",
                    actionType = ActionType.CLIPBOARD,
                    radius = shapeManager(isFirst = true, radius = settingsViewModel.settings.value.cornerRadius),
                    clipboardText = SupportConst.BITCOIN_ADDRESS
                )
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = "Monero (XMR)",
                    actionType = ActionType.CLIPBOARD,
                    radius = shapeManager(radius = settingsViewModel.settings.value.cornerRadius),
                    clipboardText = SupportConst.MONERO_ADDRESS
                )
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = "Ethereum (ETH)",
                    actionType = ActionType.CLIPBOARD,
                    radius = shapeManager(radius = settingsViewModel.settings.value.cornerRadius),
                    clipboardText = SupportConst.ETHERIUM_ADDRESS
                )
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = "BNB SMART CHAIN (BNB)",
                    actionType = ActionType.CLIPBOARD,
                    radius = shapeManager(radius = settingsViewModel.settings.value.cornerRadius),
                    clipboardText = SupportConst.BNB_SMART_ADDRESS
                )
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = "Tron (TRX)",
                    actionType = ActionType.CLIPBOARD,
                    radius = shapeManager(radius = settingsViewModel.settings.value.cornerRadius),
                    clipboardText = SupportConst.TRON_ADDRESS
                )
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = "Polygon (MATIC)",
                    actionType = ActionType.CLIPBOARD,
                    radius = shapeManager( radius = settingsViewModel.settings.value.cornerRadius),
                    clipboardText = SupportConst.POLYGON_ADDRESS
                )
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = "Avalanche C-Chain (AVAX)",
                    actionType = ActionType.CLIPBOARD,
                    radius = shapeManager(isLast = true, radius = settingsViewModel.settings.value.cornerRadius),
                    clipboardText = SupportConst.AVALANCHE_ADDRESS
                )
            }
        }
    }

}