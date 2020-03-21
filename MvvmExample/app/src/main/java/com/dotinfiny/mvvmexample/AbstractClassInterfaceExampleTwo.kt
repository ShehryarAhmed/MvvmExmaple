package com.dotinfiny.mvvmexample

fun main(arg: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = NewPlecostomus()
    println("Fish Has Color ${pleco.color}")
    pleco.eat()
}

interface NewFishAction {
    fun eat()
}

interface NewFishColor {
    val color: String
}
//Before Printing Fish Action

//class NewPlecostomus(fishColor: NewFishColor = GoldColor) : NewFishAction,
//    NewFishColor by fishColor {
//
//    override fun eat() {
//        println("They Fish Eat Only Delicious Food Okay....")
//    }
//
//}

//After Pringting Fish Action

class NewPlecostomus(fishColor: NewFishColor = GoldColor) :
    NewFishAction by PrintingFishAction("a lot of algae"),
    NewFishColor by fishColor

object GoldColor : NewFishColor {
    override val color = "Gold"
}

object RedColor : NewFishColor {
    override val color = "Red"
}

class PrintingFishAction(val food: String) : NewFishAction {
    override fun eat() {
        println(food)
    }

}