package com.plcoding.dictionary.feature_dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.plcoding.dictionary.feature_dictionary.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
//TypeConverters из-за наличия val meanings: List<Meaning>,
//так как это список его нельзя вставить в одно поле таблицы,
// его еще приходится распарсить
abstract class WordInfoDatabase: RoomDatabase() {

    abstract val dao: WordInfoDao
}