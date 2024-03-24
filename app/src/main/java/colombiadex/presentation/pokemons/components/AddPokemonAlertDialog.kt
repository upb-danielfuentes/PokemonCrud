package colombiadex.presentation.pokemons.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Slider
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import colombiadex.core.Constants.Companion.ADD
import colombiadex.core.Constants.Companion.CATEGORIA
import colombiadex.core.Constants.Companion.DESCRIPCION
import colombiadex.core.Constants.Companion.DISMISS
import colombiadex.core.Constants.Companion.NOMBRE
import colombiadex.core.Constants.Companion.NO_VALUE
import colombiadex.core.Constants.Companion.SUPERPODER
import colombiadex.domain.model.Pokemon
import colombiadex.ui.theme.ThirdColor
import kotlinx.coroutines.job

@Composable
fun AddPokemonAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addPokemon: (pokemon: Pokemon) -> Unit,
    showError: (message: String) -> Unit
) {
    if (openDialog) {
        var nombre by remember { mutableStateOf(NO_VALUE) }
        var superpoder by remember { mutableStateOf(NO_VALUE) }
        var genero by remember { mutableStateOf("Macho") }
        var descripcion by remember { mutableStateOf(NO_VALUE) }
        var peso by remember { mutableFloatStateOf(0f) }
        var altura by remember { mutableFloatStateOf(0f) }
        var categoria by remember { mutableStateOf(NO_VALUE) }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            backgroundColor = (ThirdColor),
            text = {
                Column {
                    TextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        placeholder = {
                            Text(NOMBRE)
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = superpoder,
                        onValueChange = { superpoder = it },
                        placeholder = {
                            Text(SUPERPODER)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Macho")
                            Switch(
                                checked = genero == "Macho",
                                onCheckedChange = { isChecked ->
                                    genero = if (isChecked) "Macho" else "Hembra"
                                }
                            )
                            Text("Hembra")
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = descripcion,
                        onValueChange = { descripcion = it },
                        placeholder = {
                            Text(DESCRIPCION)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Text(text = "Cuanto Pesa y Mide tu Pokemon?")
                    Slider(
                        value = peso,
                        onValueChange = { newValue ->
                            if (newValue > 0) {
                                peso = newValue
                            } else {
                                showError("El valor debe ser mayor que 0")
                            }
                        },
                        valueRange = 0f..100f,
                        steps = 100,
                        onValueChangeFinished = {}
                    )
                    Text (text = peso.toString())
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Slider(
                        value = altura,
                        onValueChange = { newValue ->
                            if (newValue > 0) {
                                altura = newValue
                            } else {
                                showError("El valor debe ser mayor que 0")
                            }
                        },
                        valueRange = 0f..100f,
                        steps = 100,
                        onValueChangeFinished = {}
                    )
                    Text (text = altura.toString())
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = categoria,
                        onValueChange = { categoria = it },
                        placeholder = {
                            Text(CATEGORIA)
                        }
                    )

                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (nombre.isBlank() || superpoder.isBlank() || genero.isBlank() || descripcion.isBlank() || categoria.isBlank()) {
                            showError("Todos los campos son obligatorios")
                        } else {
                            closeDialog()
                            val pokemon = Pokemon(0, nombre, superpoder, genero, descripcion,
                                peso, altura, categoria)
                            addPokemon(pokemon)
                        }
                    }) {
                    Text(ADD)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(DISMISS)
                }
            }

        )
    }
}