package com.dhruv.pokemon_dhruv.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<Any>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_types: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
) {

    data class Ability(
        val ability: AbilityX,
        val is_hidden: Boolean,
        val slot: Int
    )

    data class AbilityX(
        val name: String,
        val url: String
    )

    data class Animated(
        val back_default: String,
        val back_female: Any,
        val back_shiny: String,
        val back_shiny_female: Any,
        val front_default: String,
        val front_female: Any,
        val front_shiny: String,
        val front_shiny_female: Any
    )


    data class BlackWhite(
        val animated: Animated,
        val back_default: String,
        val back_female: Any,
        val back_shiny: String,
        val back_shiny_female: Any,
        val front_default: String,
        val front_female: Any,
        val front_shiny: String,
        val front_shiny_female: Any
    )


    data class Crystal(
        val back_default: String,
        val back_shiny: String,
        val back_shiny_transparent: String,
        val back_transparent: String,
        val front_default: String,
        val front_shiny: String,
        val front_shiny_transparent: String,
        val front_transparent: String
    )

    data class DiamondPearl(
        val back_default: String,
        val back_female: Any,
        val back_shiny: String,
        val back_shiny_female: Any,
        val front_default: String,
        val front_female: Any,
        val front_shiny: String,
        val front_shiny_female: Any
    )

    data class DreamWorld(
        val front_default: String,
        val front_female: Any
    )

    data class Emerald(
        val front_default: String,
        val front_shiny: String
    )

    data class FireredLeafgreen(
        val back_default: String,
        val back_shiny: String,
        val front_default: String,
        val front_shiny: String
    )

    data class Form(
        val name: String,
        val url: String
    )

    data class GameIndice(
        val game_index: Int,
        val version: Version
    )

    data class GenerationI(
        @SerializedName("red-blue")
        val redBlue: RedBlue,
        val yellow: Yellow
    )

    data class GenerationIi(
        val crystal: Crystal,
        val gold: Gold,
        val silver: Silver
    )

    data class GenerationIii(
        val emerald: Emerald,
        @SerializedName("firered-leafgreen")
        val fireredLeafgreen: FireredLeafgreen,
        @SerializedName("ruby-sapphire")
        val rubySapphire: RubySapphire
    )

    data class GenerationIv(
        @SerializedName("diamond-pearl")
        val diamondPearl: DiamondPearl,
        @SerializedName("heartgold-soulsilver")
        val heartgoldSoulsilver: HeartgoldSoulsilver,
        val platinum: Platinum
    )

    data class GenerationV(
        @SerializedName("black-white")
        val blackWhite: BlackWhite
    )

    data class GenerationVii(
        val icons: Icons,
        @SerializedName("ultra-sun-ultra-moon")
        val ultraSunUltraMoon: UltraSunUltraMoon
    )

    data class GenerationVi(
        @SerializedName("omegaruby-alphasapphire")
        val omegarubyAlphasapphire: OmegarubyAlphasapphire,
        @SerializedName("x-y")
        val xy: XY
    )

    data class GenerationViii(
        val icons: Icons
    )

    data class HeartgoldSoulsilver(
        val back_default: String,
        val back_female: Any,
        val back_shiny: String,
        val back_shiny_female: Any,
        val front_default: String,
        val front_female: Any,
        val front_shiny: String,
        val front_shiny_female: Any
    )

    data class Gold(
        val back_default: String,
        val back_shiny: String,
        val front_default: String,
        val front_shiny: String,
        val front_transparent: String
    )

    data class Home(
        val front_default: String,
        val front_female: Any,
        val front_shiny: String,
        val front_shiny_female: Any
    )

    data class Icons(
        val front_default: String,
        val front_female: Any
    )

    data class Move(
        val move: MoveX,
        val version_group_details: List<VersionGroupDetail>
    )

    data class MoveLearnMethod(
        val name: String,
        val url: String
    )

    data class MoveX(
        val name: String,
        val url: String
    )

    data class OfficialArtwork(
        val front_default: String
    )

    data class OmegarubyAlphasapphire(
        val front_default: String,
        val front_female: Any,
        val front_shiny: String,
        val front_shiny_female: Any
    )

    data class Platinum(
        val back_default: String,
        val back_female: Any,
        val back_shiny: String,
        val back_shiny_female: Any,
        val front_default: String,
        val front_female: Any,
        val front_shiny: String,
        val front_shiny_female: Any
    )

    data class Other(
        val dream_world: DreamWorld,
        val home: Home,
        @SerializedName("official-artwork")
        val officialArtwork: OfficialArtwork
    )

    data class RedBlue(
        val back_default: String,
        val back_gray: String,
        val back_transparent: String,
        val front_default: String,
        val front_gray: String,
        val front_transparent: String
    )

    data class RubySapphire(
        val back_default: String,
        val back_shiny: String,
        val front_default: String,
        val front_shiny: String
    )

    data class Silver(
        val back_default: String,
        val back_shiny: String,
        val front_default: String,
        val front_shiny: String,
        val front_transparent: String
    )
    data class Species(
        val name: String,
        val url: String
    )
    data class Sprites(
        val back_default: String,
        val back_female: Any,
        val back_shiny: String,
        val back_shiny_female: Any,
        val front_default: String,
        val front_female: Any,
        val front_shiny: String,
        val front_shiny_female: Any,
        val other: Other,
        val versions: Versions
    )
    data class Stat(
        val base_stat: Int,
        val effort: Int,
        val stat: StatX
    )
    data class StatX(
        val name: String,
        val url: String
    )
    data class Type(
        val slot: Int,
        val type: TypeX
    )
    data class TypeX(
        val name: String,
        val url: String
    )
    data class UltraSunUltraMoon(
        val front_default: String,
        val front_female: Any,
        val front_shiny: String,
        val front_shiny_female: Any
    )
    data class Version(
        val name: String,
        val url: String
    )
    data class VersionGroup(
        val name: String,
        val url: String
    )

    data class VersionGroupDetail(
        val level_learned_at: Int,
        val move_learn_method: MoveLearnMethod,
        val version_group: VersionGroup
    )
    data class Versions(
        @SerializedName("generation-i")
        val generationI: GenerationI,
        @SerializedName("generation-ii")
        val generationII: GenerationIi,
        @SerializedName("generation-iii")
        val generationIII: GenerationIii,
        @SerializedName("generation-iv")
        val generationiv: GenerationIv,
        @SerializedName("generation-v")
        val generationv: GenerationV,
        @SerializedName("generation-vi")
        val generationvi: GenerationVi,
        @SerializedName("generation-vii")
        val generationvii: GenerationVii,
        @SerializedName("generation-viii")
        val generationviii: GenerationViii
    )

    data class XY(
        val front_default: String,
        val front_female: Any,
        val front_shiny: String,
        val front_shiny_female: Any
    )
    data class Yellow(
        val back_default: String,
        val back_gray: String,
        val back_transparent: String,
        val front_default: String,
        val front_gray: String,
        val front_transparent: String
    )


}