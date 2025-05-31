package projectGit1

//start
fun main() {
    println("Вас приветствует OC")
    val command = readLine()!!

    if (command.isBlank()) {
        println("Пустой ввод - Ошибка! ")
        return
    }
    while (true) {
        if (command != "Команды") {
            throw IllegalArgumentException("Такой команды нет!")
        }

        println("Выберите -> Пароль / Try-Catch / Cat or Dog / Калькулятор / Sort / Bank / Конец ")
        val userVs = readLine()!!
        if (userVs.isBlank()) {
            println("Пустой ввод - Ошибка! ")
            return
        }
        when (userVs) {
            "Bank" -> if (bankTerminal()) return
            "Sort" -> sort()
            "Калькулятор" -> if (calculator()) break
            "Пароль" -> {
                print("Имя пользователя: ")
                val userName = readLine()!!
                if (userName.isBlank()) {
                    println("Неккоректное значение! ")
                    return
                }

                println("Придумайте пароль! ")
                val user = readLine()!!
                try {
                    if (user.length < 5) {
                        throw PasswordException("Пароль меньше 5 символов! ")
                    } else {
                        println("Ваш пароль -> $user ")
                    }
                } catch (e: PasswordException) {
                    println(e.message)
                }

                println("История паролей; ")
                val mapPassword: MutableMap<String, String> = mutableMapOf(userName to user)
                println(mapPassword)
            }

            "Try-Catch" -> {
                print("Введите число: ")
                val userTry = readLine()!!
                try {
                    val toIntVal = userTry.toInt()
                    println("Ваше число -> $toIntVal")
                } catch (e: NumberFormatException) {
                    println(("$userTry - Это не число!"))
                }
            }

            "Cat or Dog" -> {
                val dog: Box<Dog> = Box(Dog())
                val animal: Box<Animal> = dog
                println(animal.getItem())

                val animal2: Feeder<Animal> = Feeder()
                val cat: Feeder<Cat> = animal2
                cat.feed(Cat())
            }

            "Конец" -> {
                println("Конец!")
                break
            }

            else -> {
                throw IllegalArgumentException("Введите правильную команду!")
            }
        }

    }
}
