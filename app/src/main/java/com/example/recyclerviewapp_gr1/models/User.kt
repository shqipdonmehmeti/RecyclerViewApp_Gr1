package com.example.recyclerviewapp_gr1.models

data class User(
    val id : Int,
    val name : String?,
    val username : String?,
    val email : String?,
    val address : UserAddress,
    val phone : String?,
    val website : String?,
    val company : UserCompany
)

data class UserAddress(
    val street : String?,
    val suite : String?,
    val city : String?,
    val zipcode : String?,
    val geo : UserAddressGeo
)

data class UserAddressGeo(
    val lat : String?,
    val lng : String?
)

data class UserCompany(
    val name : String?,
    val catchPhrase : String?,
    val bs : String?
)