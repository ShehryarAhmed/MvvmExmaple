package com.dotinfiny.mvvmexample

abstract class AbstractClassKotlin {
    abstract val color: String
}

class SharkFish : AbstractClassKotlin(), FishAction {

    override val color = "Red"
    override fun eat() {
        println("Big Fish Eat Small Fish")
    }
}

class Plecostomus : AbstractClassKotlin(), FishAction {

    override val color = "Golden"
    override fun eat() {
        println("Small Fish Eat other items")
    }
}

fun main() {

    val sharkFish = SharkFish()
    val plecous = Plecostomus()

    println("Shark Fish Color ${sharkFish.color} and they Fish ")
    sharkFish.eat()
    println("pecos Fish Color ${plecous.color} and they Fish ")
    plecous.eat()

}

interface FishAction {
    fun eat()

    fun weight() {
        println("Hello")
    }
}