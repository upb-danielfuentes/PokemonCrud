package colombiadex.presentation.update_pokemons.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import colombiadex.core.Constants.Companion.GENERO
import colombiadex.core.Constants.Companion.NOMBRE
import colombiadex.core.Constants.Companion.SUPERPODER
import colombiadex.core.Constants.Companion.UPDATE
import colombiadex.domain.model.Pokemon

@Composable
fun UpdatePokemonContent(
    padding: PaddingValues,
    pokemon: Pokemon,
    updateNombre: (nombre: String) -> Unit,
    updateSuperPoder: (superpoder: String) -> Unit,
    updateGenero: (genero: String) -> Unit,
    updateDescripcion: (descripcion: String) -> Unit,
    updatePeso: (peso: Float) -> Unit,
    updateAltura: (altura: Float) -> Unit,
    updateCategoria: (categoria: String) -> Unit,
    updatePokemon: (pokemon: Pokemon) -> Unit,
    navigateBack: () -> Unit,
    showError: (message: String) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center)  {
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = pokemon.nombre,
            onValueChange = { nombre ->
                updateNombre(nombre)
            },
            placeholder = {
                Text(NOMBRE)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = pokemon.superpoder,
            onValueChange = { superpoder ->
                updateSuperPoder(superpoder)
            },
            placeholder = {
                Text(SUPERPODER)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = pokemon.genero,
            onValueChange = { genero ->
                updateGenero(genero)
            },
            placeholder = {
                Text(GENERO)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = pokemon.descripcion,
            onValueChange = { descripcion ->
                updateDescripcion(descripcion)
            },
            placeholder = {
                Text("Descripcion")
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Slider(
                value = pokemon.peso,
                onValueChange = { newValue ->
                    if (newValue > 0) {
                        updatePeso(newValue)
                    } else {
                        showError("El valor debe ser mayor que 0")
                    }
                },
                valueRange = 0f..100f,
                steps = 100,
                onValueChangeFinished = {

                }
            )

        }
        Text (text = pokemon.peso.toString())

            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Slider(
                value = pokemon.altura,
                onValueChange = { newValue ->
                    if (newValue > 0) {
                        updateAltura(newValue)
                    } else {
                        showError("El valor debe ser mayor que 0")
                    }
                },
                valueRange = 0f..100f,
                steps = 100,
                onValueChangeFinished = {

                }
            )
        }

            Text (text = pokemon.altura.toString())
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = pokemon.categoria,
            onValueChange = { categoria ->
                updateCategoria(categoria)
            },
            placeholder = {
                Text("Categoria")
            }
        )
        Button(
            onClick = {
                updatePokemon(pokemon)
                navigateBack()
            }
        ) {
            Text(UPDATE)
        }
    }
}






