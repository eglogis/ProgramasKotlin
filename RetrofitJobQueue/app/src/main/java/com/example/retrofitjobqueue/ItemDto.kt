package com.example.retrofitjobqueue

import com.google.gson.annotations.SerializedName

class ItemDto(

    @SerializedName("item") val item: String,
    @SerializedName("business") val business: String,
    @SerializedName("farmer_id") val farmer_id: String,
    @SerializedName("category") val category: String,
    @SerializedName("phone1") val phone1: String
)