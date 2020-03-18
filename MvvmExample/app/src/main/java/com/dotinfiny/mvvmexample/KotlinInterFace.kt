package com.dotinfiny.mvvmexample;

import kotlin.math.PI

open class Aquariums(var length: Int = 10, var width: Int = 10, var height: Int = 10) {

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open var water = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        val water = numberOfFish * 2000
        val tank = water + (water * 0.1)
        height = (tank / (length * width)).toInt()
    }

}

class TowerTank() : Aquariums() {

    override var water = volume * 0.8

    override var volume: Int
        get() = (width * height * length / 1000 * PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }

}

fun main() {
    val aquarium = Aquariums()
    println(aquarium.water)

    val towerTank = TowerTank()
    println(towerTank.water)

}

open class Book(var title: String, var author: String) {

    private var currentPage: Int = 1;
    fun readPage() = currentPage++


}

class EBook(title: String, author: String, var format: String = "text ") : Book(title, author) {

}