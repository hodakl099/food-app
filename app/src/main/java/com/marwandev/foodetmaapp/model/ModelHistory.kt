package com.marwandev.foodetmaapp.model

data class ModelHistory (
    val restaurantName : String,
    val orderDate: String,
    val itemList : ArrayList<ModelHisItem>
)