package com.dotinfiny.mvvmexample

import android.util.Log


class Aquarium(var length: Int = 10, var width: Int = 10, var height: Int = 10) {

    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    var water = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        val water = numberOfFish * 2000
        val tank = water + (water * 0.1)
        height = (tank / (length * width)).toInt()
    }

}

fun mainq() {
//    val myAquarium = Aquarium()
//
//    println(
//        "Length : ${myAquarium.length}" +
//                "Width : ${myAquarium.width}" +
//                "Height : ${myAquarium.height}"
//    )
//
//    myAquarium.height = 10
//    myAquarium.length = 10
//    myAquarium.width = 10
//
//    println("Height: ${myAquarium.height} cm")
//    println("Volume: ${myAquarium.volume} liters")
//
//    val smallAquarium = Aquarium(height = 100, length = 50, width = 75)
//    println("Small Aquarium 1 : ${smallAquarium.volume} liters")
//
//    val myAquarium2 = Aquarium(numberOfFish = 1)
//    println(
//        "small Aquarium 2 : ${myAquarium2.volume} liter with" +
//                "length ${myAquarium2.length}" +
//                "width ${myAquarium2.width}" +
//                "height ${myAquarium2.height}"
//    )

    val fish = Fish()
    fish.fishExample()
}

class Fish(val friendly: Boolean = true, val volumedNeeded: Int) {

    val size: Int

    init {
        println("first init")
    }

    constructor() : this(true, 5) {
        println("running secondary constructor")
    }

    init {
        if (friendly) {
            size = volumedNeeded
        } else {
            size = volumedNeeded * 2
        }
        println("Set size ${size}")

    }

    fun fishExample() {
        println("Create new Fish")
        val fish = Fish(true, 20)
        println("Is the fish friendly? ${fish.friendly}. It need volume ${fish.volumedNeeded} ")
    }

    init {
        println("Last init")
    }
}


class Spice(val name: String, val spiciness: String = "mild") {

    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 9
                else -> 0
            }
        }

//    val listOfSpiceness =
}


fun main() {

    val spices1 = listOf(
        Spice("curry", "mild"),
        Spice("pepper", "medium"),
        Spice("cayenne", "spicy"),
        Spice("ginger", "mild"),
        Spice("red curry", "very spicy"),
        Spice("green curry", "medium"),
        Spice("hot pepper", "extremely spicy")
    )

    val spice = Spice("Cayenne", spiciness = "spicy")

    val spiceList = spices1.filter { it.heat > 5 }

    println("Update")


}