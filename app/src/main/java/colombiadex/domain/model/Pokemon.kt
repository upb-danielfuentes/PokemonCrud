package colombiadex.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import colombiadex.core.Constants.Companion.POKEMON_TABLE
import java.net.URI

@Entity(tableName = POKEMON_TABLE)
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val superpoder: String,
    val genero: String,
    val descripcion: String,
    val peso: Float,
    val altura: Float,
    val categoria: String
) {
    val imageUrl: URI
        get() = URI("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/100.png")
}
