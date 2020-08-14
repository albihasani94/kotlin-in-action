package com.albi

import java.lang.NumberFormatException

data class Person(val name: String, val age: Int? = null)

fun main() {
    // Java 9 for ya
    val persons = listOf(Person("Alice"), Person("BoB", 29))

    val oldest = findOldest(persons)
    println("The oldest person is $oldest") // The oldest person is com.albi.Person(name=BoB, age=29)

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

    // play with person
    val person = PersonClass("Vin", false)
    person.isMarried = true;
    println("${person.name} is married: ${person.isMarried}");
    println(person.hasChildren)

    // test this function which uses "when"
    println(getWarmth(Color.RED))

    // ranges
    val oneToTen = 1..5
    oneToTen.forEach { println("Printing range element $it")}

    // exceptions
    val number = try {
        Integer.parseInt("One")
    } catch (e: NumberFormatException) {
        0
    }
    println(number)
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
