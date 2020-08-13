data class Person(val name: String, val age: Int? = null)

fun main() {
    // Java 9 for ya
    val persons = listOf(Person("Alice"), Person("BoB", 29))

    val oldest = findOldest(persons)
    println("The oldest person is $oldest") // The oldest person is Person(name=BoB, age=29)

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
}

// What a taste of lambda - block body
fun findOldest(persons: List<Person>): Person? {
    return persons.maxBy { it.age ?: 0 }
}

// Functions are fun - expression body
fun max(a: Int, b: Int) = if (a > b) a else b
