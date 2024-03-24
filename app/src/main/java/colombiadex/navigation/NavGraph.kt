package colombiadex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import colombiadex.core.Constants.Companion.POKEMON_ID
import colombiadex.navigation.Screen.PokemonsScreen
import colombiadex.navigation.Screen.UpdatePokemonScreen
import colombiadex.presentation.pokemons.PokemonsScreen
import colombiadex.presentation.update_pokemons.UpdatePokemonScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = PokemonsScreen.route
    ) {
        composable(
            route = PokemonsScreen.route
        ) {
            PokemonsScreen(
                navigateToUpdatePokemonScreen = { pokemonId ->
                    navController.navigate(
                        "${UpdatePokemonScreen.route}/${pokemonId}"
                    )
                }
            )
        }
        composable(
            route = "${UpdatePokemonScreen.route}/{$POKEMON_ID}",
            arguments = listOf(
                navArgument(POKEMON_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getInt(POKEMON_ID) ?: 0
            UpdatePokemonScreen(
                pokemonId = pokemonId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}