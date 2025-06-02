package projectGit1

//start
fun main() {
    val mapFunPassword = mutableMapOf<String, String>()
    println("Вас приветствует OC")
    val userStart = readLine()!!

    if (userStart.isBlank() || userStart != "Команды") {
        throw IllegalArgumentException("Ошибка! ")
    }
    while (true) {
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
            "Пароль" -> if (password(mapFunPassword)) return
            "Try-Catch" -> tryCatch()
            "Cat or Dog" -> carOrDog()
            "Конец" -> {
                finish()
                break
            }

            else -> throw IllegalArgumentException("Введите правильную команду!")
        }
    }
}