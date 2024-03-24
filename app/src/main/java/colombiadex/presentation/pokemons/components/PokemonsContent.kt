package colombiadex.presentation.pokemons.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import colombiadex.domain.model.Pokemon
import colombiadex.domain.repository.Pokemons
import colombiadex.ui.theme.OtherColor


@Composable
fun PokemonsContent(
    padding: PaddingValues,
    pokemons: Pokemons,
    deletePokemon: (pokemon: Pokemon) -> Unit,
    navigateToUpdatePokemonScreen: (pokemonId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(OtherColor)
            .padding(padding)
    ) {
        items(pokemons) { pokemon ->
            PokemonCard(
                pokemon = pokemon,
                deletePokemon = {
                    deletePokemon(pokemon)
                },
                navigateToUpdatePokemonScreen =
                navigateToUpdatePokemonScreen
            )
        }
    }
}