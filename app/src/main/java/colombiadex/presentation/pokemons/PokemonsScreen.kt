package colombiadex.presentation.pokemons

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import colombiadex.core.Constants.Companion.POKEMON_SCREEN
import colombiadex.presentation.pokemons.components.AddPokemonAlertDialog
import colombiadex.presentation.pokemons.components.AddPokemonFloatingActionButton
import colombiadex.presentation.pokemons.components.PokemonAlertDialog
import colombiadex.presentation.pokemons.components.PokemonsContent

@Composable
fun PokemonsScreen(
    viewModel: PokemonsViewModel = hiltViewModel(),
    navigateToUpdatePokemonScreen: (pokemonId: Int) -> Unit
) {
    val pokemons by viewModel.pokemons.collectAsState(
        initial = emptyList()
    )
    val showDialog = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(POKEMON_SCREEN)
                },
                actions = {
                    IconButton(onClick = { showDialog.value = true }) {
                        Icon(Icons.Filled.Face, contentDescription = null)
                    }
                }
            )
        },
        content = { padding ->
            PokemonsContent(
                padding = padding,
                pokemons = pokemons,
                deletePokemon = { pokemon ->
                    viewModel.deletePokemon(pokemon)
                },
                navigateToUpdatePokemonScreen =
                navigateToUpdatePokemonScreen
            )
            if (showDialog.value) {
                PokemonAlertDialog()
            }
            AddPokemonAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addPokemon = { pokemon ->
                    viewModel.addPokemon(pokemon)
                },
                showError = { message ->
                    System.out.println("Error: $message")
                }
            )
        },
        floatingActionButton = {
            AddPokemonFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}
