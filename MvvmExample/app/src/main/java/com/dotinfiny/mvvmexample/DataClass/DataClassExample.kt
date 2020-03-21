package com.dotinfiny.mvvmexample.DataClass

fun main(array: Array<String>) {

    makeDecoration()

}

fun makeDecoration() {

    val d1 = Decorations("granite")
    println(d1)

    val d2 = Decorations("slate")
    println(d2)

    val d3 = Decorations("slate")
    println(d3)

    val d4 = d3.copy()
    println(d1.equals(d2))
    println(d2.equals(d3))

    val d5 = Decorations2("slate", "Wood", "Diver")
    println(d5.diver)

    println(d4.equals(d5))

    var (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)

}

data class Decorations(val rocks: String) {}

data class Decorations2(val rocks: String, val wood: String, val diver: String) {}


data class spiceContainer(val spice:String){
    val lable = spice
}


interface Testing{
    fun hello()
}