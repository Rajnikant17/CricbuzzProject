package com.example.localdatabase.models

import com.google.gson.annotations.SerializedName

data class Restaurant (
    var id: Int,
    var name: String,
    var neighborhood: String,
    var address: String,
    @SerializedName("cuisine_type")
    var cuisineType: String ,
    var cuisineTypeListSepratedByComma: List<String> ,
    var menu:Menu ,
    var menuItemSepratedByComma:String
    )