package com.albi.part.one

import java.lang.NumberFormatException
import java.lang.RuntimeException
import kotlin.math.PI

data class Person(val name: String, val age: Int? = null)

const val WARNING = "It's too hot outside"

fun main() {
    // Java 9 for ya
    val persons = listOf(
        Person("Alice"),
        Person("BoB", 29)
    )

    val oldest = findOldest(persons)
    println("The oldest person is $oldest") // The oldest person is com.albi.part.one.Person(name=BoB, age=29)

    // Look at this nice string templating
    val a = 5
    val b = 6
    // b = 8; reassignment not allowed for val
    println("Max of $a and $b is ${max(a, b)}")

    val question = "The solution to my problems"
    var answer = 42
    answer = 10 // this answer  does not make sense; var allows reassignment tho
    // answer = drugs; not allowerd due to type mismatch
    println("$question is $answer")

    // play with person - also named argument
    val person = PersonClass("Vin", isMarried = false)
    person.isMarried = true;
    println("${person.name} is married: ${person.isMarried}");
    println(person.hasChildren)

    // test this function which uses "when"
    println(getWarmth(Color.RED))

    // ranges
    val oneToTen = 1..5
    oneToTen.forEach { println("Printing range element $it") }

    // exceptions
    val number = try {
        Integer.parseInt("One")
    } catch (e: NumberFormatException) {
        0
    }
    println(number)

    // print warning
    println(WARNING)

    // test extension function
    val hello = "hello"
    println("The last char of $hello is ${hello.lastChar()}")

    // spread operator
    var arrayOfNums = arrayOf(1, 2, 3)
    val list = listOf(*arrayOfNums, 4, 5)
    list.forEach { println(it) }

    // maps - infix to calls
    val map = mapOf(1 to "one", 2 to "two", 3 to "thee")
    map.forEach {
        println(it)
    }

    // multiline strings
    val multiline = """
        hevo
                there
                        dummy
    """.trimIndent()
    println(multiline)

    // local functions
    fun positiveDistancesToTen(number: Int, number1: Int): Pair<Int, Int> {
        fun validate(number: Int) {
            if (number >= 10)
                throw RuntimeException("Number should be less than 10")
        }

        validate(number)
        validate(number1)

        return 10 - number to 10 - number1
    }

    println(positiveDistancesToTen(4, 6))
    println(positiveDistancesToTen(5, 8))

    // use the interface
    val button = Button()
    button.click()
    button.defaultMethod()

    // test singleton - object
    Singleton.doSomething()
}

// What a taste of lambda - block body
fun findOldest(persons: List<Person>): Person? {
    return persons.maxBy { it.age ?: 0 }
}

// Functions are fun - expression body, no return needed
fun max(a: Int, b: Int) = if (a > b) a else b

// short class
class PersonClass(
    val name: String,
    var isMarried: Boolean
) {
    val hasChildren: Boolean
        get() = false
}

// enum class in kotlin
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255);

    fun rgb() = (r * 256 + g) * 256 + b
}

// when statement in kotlin
fun getWarmth(color: Color) =
    when (color) {
        Color.RED -> "warm"
        Color.GREEN -> "neutral"
        Color.BLUE -> "cold"
    }

// extension function
fun String.lastChar(): Char = this.get(this.length - 1)

// declaring an interface
interface Clickable {
    fun click()
    fun defaultMethod() = println("Default clickable method")
}

// implement the interface
class Button : Clickable {
    override fun click() = println("Clicked button")
}

// abstract class
abstract class Animated {
    abstract fun animate()

    open fun stopAnimaction() = println("Stopping animation...")
}

// sealed class
sealed class Shape {
    class Triangle(val a: Int, val b: Int, val c: Int) : Shape()
    class Rectangular(val a: Int) : Shape()
    class Circle(val r: Int) : Shape()
}

// make use of sealed class
fun calculatePerimeter(shape: Shape): Number =
    when (shape) {
        is Shape.Triangle -> shape.a + shape.b + shape.c
        is Shape.Rectangular -> 4 * shape.a
        is Shape.Circle -> 2 * PI * shape.r
    }


object Singleton {
    val shapes = arrayListOf<Shape>(
        Shape.Triangle(3, 4, 5),
        Shape.Rectangular(4),
        Shape.Circle(2)
    )

    fun doSomething() {
        for (shape in shapes) {
            println(calculatePerimeter(shape))
        }
    }
}
