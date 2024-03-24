package colombiadex.navigation

import colombiadex.core.Constants.Companion.POKEMON_SCREEN
import colombiadex.core.Constants.Companion.UPDATE_POKEMON_SCREEN

sealed class Screen(val route: String) {
    object PokemonsScreen : Screen(POKEMON_SCREEN)
    object UpdatePokemonScreen : Screen(UPDATE_POKEMON_SCREEN)
}
