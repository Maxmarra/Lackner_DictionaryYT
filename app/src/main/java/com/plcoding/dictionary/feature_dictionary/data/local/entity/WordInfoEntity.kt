package com.plcoding.dictionary.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plcoding.dictionary.feature_dictionary.domain.model.Meaning
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val origin: String?,
    //из-за этого списка мы создаем кучу файлов
    //по хорошему для него нужно делать отдельную таблицу
    //но можно сделать просто конвертирование
    // data-util - JsonParser, GsonParser
    // local - Converters
    // обрати внимание на аннотации! (в WordInfoDatabase тоже нужна!!!)
    // так же в классе создания базы данных нужно указать этот конвертер
    // (либо в Dagger в WordInfoModule .addTypeConverter(Converters(GsonParser(Gson()))))
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            word = word,
            origin = origin,
            phonetic = phonetic
        )
    }
}
