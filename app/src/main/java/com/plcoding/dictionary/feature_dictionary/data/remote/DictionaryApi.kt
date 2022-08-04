package com.plcoding.dictionary.feature_dictionary.data.remote

import com.plcoding.dictionary.feature_dictionary.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    // в {word} будет передаваться слово из поиска!
    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word: String
    ): List<WordInfoDto> // возвращаем лист потому что у одного слова может быть много значений

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/"
    }
}