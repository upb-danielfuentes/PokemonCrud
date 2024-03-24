package colombiadex.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import colombiadex.domain.model.Pokemon

@Database(entities = [Pokemon::class], version = 1, exportSchema = false)
abstract class PokemonDB : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}