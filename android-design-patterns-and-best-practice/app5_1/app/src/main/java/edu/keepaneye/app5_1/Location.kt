package edu.keepaneye.app5_1

interface OldLocation {
    val building: String
    val floor: Int
    val office: String
    val desk: Int
}

data class CustomerLocation(
    override val building:String,
    override val floor: Int,
    override val office: String,
    override val desk: Int
    ):OldLocation


interface NewLocation {
    val building: String
    val floor: Int
    val desk: Int
}

class LocationAdapter(val location:OldLocation) : NewLocation {
    override val building: String = location.building
    override val floor: Int= location.floor
    override val desk: Int= location.desk
}

