package colombiadex.presentation.update_pokemons.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.runtime.Composable
import colombiadex.core.Constants.Companion.UPDATE_POKEMON_SCREEN

@Composable
fun UpdatePokemonTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar(
        title = {
            Text(UPDATE_POKEMON_SCREEN)
        },
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
}