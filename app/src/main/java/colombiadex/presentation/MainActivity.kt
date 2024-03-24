package colombiadex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import colombiadex.navigation.NavGraph
import colombiadex.ui.theme.PokemonCrudTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonCrudTheme {
                NavGraph(navController = rememberNavController())
            }
        }
    }
}