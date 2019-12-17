package com.bymdev.pass2sdk.enums

enum class SortType(val type: String) {
    NAME_ASC("name.raw,asc"),
    NAME_DESC("name.raw,desc"),
    PRICE_ASC("options.availabilities.price.price,asc"),
    PRICE_DESC("options.availabilities.price.price,desc")
}