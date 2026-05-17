package com.example.starcalculator.data.mappers

import com.example.starcalculator.data.entity.HomeEntity
import com.example.starcalculator.domain.model.HomeData

fun HomeEntity.toDomain(): HomeData {
    return HomeData(
        id = id,
        stars = stars,
        targetStar = targetStar,
        scrapyardV2 = scrapyardV2,
        achievementLvl2 = achievementLvl2,
        masteryLvl17 = masteryLvl17,
        isMagicBox = isMagicBox
    )
}

fun HomeData.toEntity(): HomeEntity {
    return HomeEntity(
        id = id,
        stars = stars,
        targetStar = targetStar,
        scrapyardV2 = scrapyardV2,
        achievementLvl2 = achievementLvl2,
        masteryLvl17 = masteryLvl17,
        isMagicBox = isMagicBox
    )
}
