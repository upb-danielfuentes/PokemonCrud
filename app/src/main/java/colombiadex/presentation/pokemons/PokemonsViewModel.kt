package colombiadex.presentation.pokemons

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import colombiadex.core.Constants.Companion.NO_VALUE
import colombiadex.domain.model.Pokemon
import colombiadex.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonsViewModel @Inject constructor(
    private val repo: PokemonRepository
) : ViewModel() {

    var pokemon by mutableStateOf(Pokemon(0, NO_VALUE, NO_VALUE, NO_VALUE, NO_VALUE, 0f,
        0f, NO_VALUE))
    var openDialog by mutableStateOf(false)
    val pokemons = repo.getPokemonsFromRoom()
    fun addPokemon(pokemon: Pokemon) = viewModelScope.launch(Dispatchers.IO)
    {
        repo.addPokemonToRoom(pokemon)
    }

    fun closeDialog() {
        openDialog = false
    }

    fun openDialog() {
        openDialog = true
    }

    fun deletePokemon(pokemon: Pokemon) =
        viewModelScope.launch(Dispatchers.IO) {
            repo.deletePokemonFromRoom(pokemon)
        }

    fun updateNombre(nombre: String) {
        pokemon = pokemon.copy(
            nombre = nombre
        )
    }

    fun updateSuperPoder(superpoder: String) {
        pokemon = pokemon.copy(
            superpoder = superpoder
        )
    }
     fun updateGenero(genero: String) {
        pokemon = pokemon.copy(
            genero = genero
        )
     }
    fun updateDescripcion(descripcion: String) {
        pokemon = pokemon.copy(
            descripcion = descripcion
        )
    }
    fun updatePeso(peso: Float) {
        pokemon = pokemon.copy(
            peso = peso
        )
    }
    fun updateAltura(altura: Float) {
        pokemon = pokemon.copy(
            altura = altura
        )
    }
    fun updateCategoria(categoria: String) {
        pokemon = pokemon.copy(
            categoria = categoria
        )
    }

    fun updatePokemon(pokemon: Pokemon) =
        viewModelScope.launch(Dispatchers.IO) {
            repo.updatePokemonInRoom(pokemon)
        }

    fun getPokemon(id: Int) = viewModelScope.launch(
        Dispatchers.IO
    ) {
        pokemon = repo.getPokemonFromRoom(id)
    }
}