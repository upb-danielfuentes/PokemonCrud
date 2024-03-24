package colombiadex.domain.repository

import colombiadex.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

typealias Pokemons = List<Pokemon>

interface PokemonRepository {
    fun getPokemonsFromRoom(): Flow<Pokemons>
    fun addPokemonToRoom(pokemon: Pokemon)
    fun getPokemonFromRoom(id: Int): Pokemon
    fun updatePokemonInRoom(pokemon: Pokemon)
    fun deletePokemonFromRoom(pokemon: Pokemon)


}