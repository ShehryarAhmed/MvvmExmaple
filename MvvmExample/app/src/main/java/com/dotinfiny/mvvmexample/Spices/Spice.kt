package com.dotinfiny.mvvmexample.Spices

fun main() {

    val curry = Curry("", "")
    curry.prepareSpice()
    println(curry.color)
}


abstract class Spice(val name: String, val spiciness: String = "mild", color: SpicyColor) :
    SpicyColor by color {

    abstract fun prepareSpice()

}

interface Grinder {
    fun grind()
}

class Curry(name: String, spiciness: String = "mild", color: SpicyColor = YellowSpiceColor) :
    Spice(name, spiciness, color), Grinder {

    override fun prepareSpice() {
        grind()
    }

    override fun grind() {
        println("Do Something here")
    }

}

interface SpicyColor {
    val color: String
}

object YellowSpiceColor : SpicyColor {
    override val color = "Yellow Spice Color"

}