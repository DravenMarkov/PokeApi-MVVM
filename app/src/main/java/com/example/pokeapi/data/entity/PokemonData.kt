package com.example.pokeapi.data.entity

import com.google.gson.annotations.SerializedName

data class PokemonData(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<HeldItem>,
    @SerializedName("id")
    val pokedex_number: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
) {
    data class Ability(
        val ability: Ability,
        val is_hidden: Boolean,
        val slot: Int
    ) {
        data class Ability(
            val name: String,
            val url: String
        )
    }

    data class Form(
        val name: String,
        val url: String
    )

    data class GameIndice(
        val game_index: Int,
        val version: Version
    ) {
        data class Version(
            val name: String,
            val url: String
        )
    }

    data class HeldItem(
        val item: Item,
        val version_details: List<VersionDetail>
    ) {
        data class Item(
            val name: String,
            val url: String
        )

        data class VersionDetail(
            val rarity: Int,
            val version: Version
        ) {
            data class Version(
                val name: String,
                val url: String
            )
        }
    }

    data class Move(
        val move: Move,
        val version_group_details: List<VersionGroupDetail>
    ) {
        data class Move(
            val name: String,
            val url: String
        )

        data class VersionGroupDetail(
            val level_learned_at: Int,
            val move_learn_method: MoveLearnMethod,
            val version_group: VersionGroup
        ) {
            data class MoveLearnMethod(
                val name: String,
                val url: String
            )

            data class VersionGroup(
                val name: String,
                val url: String
            )
        }
    }

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
    ) {
        data class Other(
            val dream_world: DreamWorld,
            @SerializedName("official-artwork")
            val officialartwork: OfficialArtwork
        ) {
            data class DreamWorld(
                val front_default: String,
                val front_female: Any
            )

            data class OfficialArtwork(
                val front_default: String
            )
        }

        data class Versions(
            val generationi: GenerationI,
            @SerializedName("generation-ii")
            val generationii: GenerationIi,
            @SerializedName("generation-iii")
            val generationiii: GenerationIii,
            @SerializedName("generation-iv")
            val generationiv: GenerationIv,
            @SerializedName("generation-v")
            val generationv: GenerationV,
            @SerializedName("generation-vi")
            val generationvi: GenerationVi,
            @SerializedName("generation-vii")
            val generationvii: GenerationVii
        ) {
            data class GenerationI(
                @SerializedName("red-blue")
                val redblue: RedBlue,
                val yellow: Yellow
            ) {
                data class RedBlue(
                    val back_default: String,
                    val back_gray: String,
                    val front_default: String,
                    val front_gray: String
                )

                data class Yellow(
                    val back_default: String,
                    val back_gray: String,
                    val front_default: String,
                    val front_gray: String
                )
            }

            data class GenerationIi(
                val crystal: Crystal,
                val gold: Gold,
                val silver: Silver
            ) {
                data class Crystal(
                    val back_default: String,
                    val back_shiny: String,
                    val front_default: String,
                    val front_shiny: String
                )

                data class Gold(
                    val back_default: String,
                    val back_shiny: String,
                    val front_default: String,
                    val front_shiny: String
                )

                data class Silver(
                    val back_default: String,
                    val back_shiny: String,
                    val front_default: String,
                    val front_shiny: String
                )
            }

            data class GenerationIii(
                val emerald: Emerald,
                @SerializedName("firered-leafgreen")
                val fireredleafgreen: FireredLeafgreen,
                @SerializedName("ruby-sapphire")
                val rubysapphire: RubySapphire
            ) {
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

                data class RubySapphire(
                    val back_default: String,
                    val back_shiny: String,
                    val front_default: String,
                    val front_shiny: String
                )
            }

            data class GenerationIv(
                @SerializedName("diamond-pearl")
                val diamondpearl: DiamondPearl,
                @SerializedName("heartgold-soulsilver")
                val heartgoldfsoulsilver: HeartgoldSoulsilver,
                val platinum: Platinum
            ) {
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
            }

            data class GenerationV(
                val blackwhite: BlackWhite
            ) {
                data class BlackWhite(
                    val back_default: String,
                    val back_female: Any,
                    val back_shiny: String,
                    val back_shiny_female: Any,
                    val front_default: String,
                    val front_female: Any,
                    val front_shiny: String,
                    val front_shiny_female: Any
                )
            }

            data class GenerationVi(
                val omegarubyalphasapphire: OmegarubyAlphasapphire,
                val xy: XY
            ) {
                data class OmegarubyAlphasapphire(
                    val front_default: String,
                    val front_female: Any,
                    val front_shiny: String,
                    val front_shiny_female: Any
                )

                data class XY(
                    val front_default: String,
                    val front_female: Any,
                    val front_shiny: String,
                    val front_shiny_female: Any
                )
            }

            data class GenerationVii(
                val ultrasunultramoon: UltraSunUltraMoon
            ) {
                data class UltraSunUltraMoon(
                    val front_default: String,
                    val front_female: Any,
                    val front_shiny: String,
                    val front_shiny_female: Any
                )
            }
        }
    }

    data class Stat(
        val base_stat: Int,
        val effort: Int,
        val stat: Stat
    ) {
        data class Stat(
            val name: String,
            val url: String
        )
    }

    data class Type(
        val slot: Int,
        val type: Type
    ) {
        data class Type(
            val name: String,
            val url: String
        )
    }
}