package com.notenow.app.presentation.screens.settings.settings

import android.provider.MediaStore
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.Style
import androidx.compose.material.icons.rounded.Swipe
import androidx.compose.material.icons.rounded.Title
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.notenow.app.R
import com.notenow.app.presentation.components.unregisterGalleryObserver
import com.notenow.app.presentation.screens.settings.SettingsScaffold
import com.notenow.app.presentation.screens.settings.model.SettingsViewModel
import com.notenow.app.presentation.screens.settings.widgets.ActionType
import com.notenow.app.presentation.screens.settings.widgets.SettingsBox

@Composable
fun MarkdownScreen(navController: NavController, settingsViewModel: SettingsViewModel) {
    SettingsScaffold(
        settingsViewModel = settingsViewModel,
        title = stringResource(id = R.string.Behavior),
        onBackNavClicked = { navController.navigateUp() }
    ) {
        val context = LocalContext.current
        LazyColumn {
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = stringResource(id = R.string.markdown),
                    description = stringResource(id = R.string.markdown_description),
                    icon = Icons.Rounded.Style,
                    actionType = ActionType.SWITCH,
                    radius = shapeManager(isBoth = true, radius = settingsViewModel.settings.value.cornerRadius),
                    variable = settingsViewModel.settings.value.isMarkdownEnabled,
                    switchEnabled = { settingsViewModel.update(settingsViewModel.settings.value.copy(isMarkdownEnabled = it))}
                )
                Spacer(modifier = Modifier.height(18.dp))
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = stringResource(id = R.string.always_edit),
                    description = stringResource(id = R.string.always_edit_description),
                    icon = Icons.Rounded.Edit,
                    actionType = ActionType.SWITCH,
                    radius = shapeManager(isFirst = true, radius = settingsViewModel.settings.value.cornerRadius),
                    variable = settingsViewModel.settings.value.editMode,
                    switchEnabled = { settingsViewModel.update(settingsViewModel.settings.value.copy(editMode = it))}
                )
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = stringResource(id = R.string.gallery_sync),
                    description = stringResource(id = R.string.gallery_sync_description),
                    icon = Icons.Rounded.Image,
                    actionType = ActionType.SWITCH,
                    radius = shapeManager(isLast = true, radius = settingsViewModel.settings.value.cornerRadius),
                    variable = settingsViewModel.settings.value.gallerySync,
                    switchEnabled = {
                        if (!it) {
                            unregisterGalleryObserver(context, settingsViewModel.galleryObserver)
                        } else {
                            context.contentResolver.registerContentObserver(
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                true,
                                settingsViewModel.galleryObserver
                            )
                        }
                        settingsViewModel.update(settingsViewModel.settings.value.copy(gallerySync = it))
                    }
                )
            }

            item {
                Spacer(modifier = Modifier.height(18.dp))
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = stringResource(id = R.string.show_only_title),
                    description = stringResource(id = R.string.show_only_title_description),
                    icon = Icons.Rounded.Title,
                    actionType = ActionType.SWITCH,
                    radius = shapeManager(isFirst = true, radius = settingsViewModel.settings.value.cornerRadius),
                    variable = settingsViewModel.settings.value.showOnlyTitle,
                    switchEnabled = {
                        settingsViewModel.update(settingsViewModel.settings.value.copy(showOnlyTitle = it))
                    }
                )
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = stringResource(id = R.string.disable_swipe_edit),
                    description = stringResource(id = R.string.disable_swipe_edit_description),
                    icon = Icons.Rounded.Swipe,
                    actionType = ActionType.SWITCH,
                    radius = shapeManager(isLast = true, radius = settingsViewModel.settings.value.cornerRadius),
                    variable = settingsViewModel.settings.value.disableSwipeInEditMode,
                    switchEnabled = {
                        settingsViewModel.update(settingsViewModel.settings.value.copy(disableSwipeInEditMode = it))
                    }
                )
            }
        }
    }

}