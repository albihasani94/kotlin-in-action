data class Person(val name: String, val age: Int? = null)

fun main() {
    val persons = listOf(Person("Alice"), Person("BoB", 29))

    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest person is $oldest")
}