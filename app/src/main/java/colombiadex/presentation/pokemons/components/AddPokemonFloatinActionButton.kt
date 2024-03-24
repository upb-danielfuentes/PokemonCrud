package colombiadex.presentation.pokemons.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import colombiadex.core.Constants.Companion.ADD_POKEMON

@Composable
fun AddPokemonFloatingActionButton(
    openDialog: () -> Unit
) {
    FloatingActionButton(
        onClick = openDialog,
        backgroundColor = MaterialTheme.colors.onPrimary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ADD_POKEMON
        )
    }
}