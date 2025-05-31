package projectGit1


abstract class Animal

class User(var age: Int = 0, var balance: Int)

class Bank(var balance: Int = 100000)

class Dog : Animal() {
    override fun toString(): String = "Собака"
}

class Cat : Animal() {
    override fun toString(): String = "Кошка"
}

class Box<out T : Animal>(private val value: T) {
    fun getItem(): T = value
}

class Feeder<in T : Animal> {
    fun feed(animal: T) = println(animal)
}

class PasswordException(name: String) : Exception(name)