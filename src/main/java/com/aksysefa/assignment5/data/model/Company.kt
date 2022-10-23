package com.aksysefa.assignment5.data.model


import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("bs")
    val bs: String?,
    @SerializedName("catchPhrase")
    val catchPhrase: String?,
    @SerializedName("name")
    val name: String?
)