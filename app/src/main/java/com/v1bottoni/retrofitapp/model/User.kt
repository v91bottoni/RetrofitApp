package com.v1bottoni.retrofitapp.model

data class User(
    var id: Int?,
    var name: String?,
    var username: String?,
    var email: String?,
    var address: UserAddress?,
    var phone: String?,
    var company: Company
)
