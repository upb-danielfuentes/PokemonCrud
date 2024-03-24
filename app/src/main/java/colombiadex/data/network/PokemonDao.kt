package colombiadex.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Update
import colombiadex.core.Constants.Companion.POKEMON_TABLE
import colombiadex.domain.model.Pokemon
import colombiadex.domain.repository.Pokemons
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM $POKEMON_TABLE ORDER BY id ASC")
    fun getPokemons(): Flow<Pokemons>

    @Insert(onConflict = IGNORE)
    fun addPokemon(pokemon: Pokemon)

    @Query("SELECT * FROM $POKEMON_TABLE WHERE id = :id")
    fun getPokemon(id: Int): Pokemon

    @Update
    fun updatePokemon(pokemon: Pokemon)

    @Delete
    fun deletePokemon(pokemon: Pokemon)

}