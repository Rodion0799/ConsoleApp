package projectGit1

/**
 * Демонстрация простого калькулятора
 * с обработкой ввода и базовых арифметических операций.
 */
fun calculator(): Boolean {
    print("Введите первое число -> ")
    val a = readLine()!!.toInt()
    print("Введите второе число -> ")
    val b = readLine()!!.toInt()
    print("Введите операцию -> ")
    val userOperation = readLine()!!


    if (userOperation == "+" || userOperation == "-" || userOperation == "*" || userOperation == "/") {
        when (userOperation) {
            "+" -> println("$a + $b = ${a + b}")
            "-" -> println("$a - $b = ${a - b}")
            "/" -> if (b != 0) {
                println("$a / $b = ${a / b}")
            } else {
                println("На 0 деление запрещено!")
            }

            "*" -> println("$a * $b = ${a * b}")
        }
    } else {
        println("Не правильная операция!")
        return true
    }
    return false
}


/**
 * sort
 */
fun sort() {
    print("Введите числа для сортировки -> ")
    val userSort = readLine() ?: ""

    try {
        val numbers = userSort.split(", ")
            .map { it.toInt() }
            .sorted()
        println(numbers)
    } catch (e: NumberFormatException) {
        println("Вы ввели не число! ")
    } catch (e: IllegalArgumentException) {
        println("Введите числа через запятую! ")
    }
}


/**
 * Демонстрация работ банковского терминала
 * @return Boolean -> true (если баланса хватает) false (если не хватает)
 */
fun bankTerminal(): Boolean {
    print("Введите сумму для пополнения -> ")
    val userInt = readLine()!!.toIntOrNull()
    print("Введите имя пользователя -> ")
    val userName = readLine()!!
    if (userName.isBlank()) {
        println("Повторитек попытку! ")
        return true
    }
    if (userInt == null) {
        println("Введите сумму! ")
    }

    val userBank1 = User(
        balance = 1500
    )

    val bank = Bank()

    if (userBank1.balance < userInt!!) {
        println("Недостаточно средств! ")
        return true
    } else if (userInt <= bank.balance && userInt > 0) {
        bank.balance += userInt
        userBank1.balance -= userInt
        println("Баланс $userName -> ${userBank1.balance}\nБаланс банка -> ${bank.balance}")
    }
    return false
}


/**
 * Демонстрация валидации ввода при регистрации:
 * проверка логина и пароля,
 * использование MutableMap,
 * обработка исключений, вывод данных.
 */
fun password(map: MutableMap<String, String>): Boolean {
    print("Имя пользователя: ")
    val userName = readLine()!!
    if (userName.isBlank()) {
        println("Неккоректное значение! ")
        return true
    }

    print("Придумайте пароль: ")
    val userPassword = readLine()!!
    try {
        if (userPassword.length < 5) {
            throw PasswordException("Пароль меньше 5 символов! ")
        } else {
            map.put(userName, userPassword)
        }
    } catch (e: PasswordException) {
        println(e.message)
    }
    map.forEach { name, password ->
        println("$name: $password")
    }
    return false
}


/**
 * Демонстрация обработки исключений
 * при преобразовании строки в число с использованием try-catch.**
 */
fun tryCatch() {
    print("Введите число: ")
    val userString = readLine()!!
    if (userString.isBlank()) {
        println("Пустой ввод!")
        return
    }
    try {
        val userInt = userString.toInt()
        println("Ваше число -> $userInt")
    } catch (e: NumberFormatException) {
        println("$userString - Это не число!")
    }
}

/**
 * Демонстрация ковариантности и контрвариантности с использованием in и out.
 */
fun carOrDog() {
    val dog: Box<Dog> = Box(Dog())
    val animal: Box<Animal> = dog
    println(animal.getItem())

    val animal2: Feeder<Animal> = Feeder()
    val cat: Feeder<Cat> = animal2
    cat.feed(Cat())
}

/**
 * Finish
 */
fun finish() {
    println("До скорых встреч!")
}