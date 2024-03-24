package colombiadex.presentation.pokemons.components

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import colombiadex.api.PokemonApi.getRandomPokemon
import kotlinx.coroutines.launch

@Composable
fun PokemonAlertDialog() {
    val showDialog = remember { mutableStateOf(false) }
    val pokemonName = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val showButton = remember { mutableStateOf(true) }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("¡Un Pokémon salvaje apareció!", style =MaterialTheme.typography.h4)
                Spacer(modifier = Modifier.padding(10.dp))
            },
            text = { Text("¡Es un ${pokemonName.value}!", style = MaterialTheme.typography.h4)
                },
            confirmButton = {
                Button(
                    onClick = { showDialog.value = false },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("OK")
                }
            }
        )
    }

    if (showButton.value) {
        Button(
            onClick = {
                scope.launch {
                    try {
                        pokemonName.value = getRandomPokemon()
                        showDialog.value = true
                        showButton.value = false
                    } catch (e: Exception) {
                        Log.e("PokemonAlertDialog", "Error al obtener el Pokémon", e)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            Text("Mostrar Pokémon Aleatorio")
        }
    }
}