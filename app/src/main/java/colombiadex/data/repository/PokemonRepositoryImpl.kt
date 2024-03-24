package colombiadex.data.repository

import colombiadex.data.network.PokemonDao
import colombiadex.domain.model.Pokemon
import colombiadex.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val pokemonDao: PokemonDao
) : PokemonRepository {
    override fun getPokemonsFromRoom() = pokemonDao.getPokemons()
    override fun addPokemonToRoom(pokemon: Pokemon) = pokemonDao.addPokemon(pokemon)

    override fun getPokemonFromRoom(id: Int) = pokemonDao.getPokemon(id)

    override fun updatePokemonInRoom(pokemon: Pokemon) =
        pokemonDao.updatePokemon(pokemon)

    override fun deletePokemonFromRoom(pokemon: Pokemon) =
        pokemonDao.deletePokemon(pokemon)


}
