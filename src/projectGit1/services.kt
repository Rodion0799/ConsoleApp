package projectGit1


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
        val numbers = userSort.split(" ")
            .map { it.toInt() }
            .sorted()
        println(numbers)
    } catch (e: NumberFormatException) {
        println("Вы ввели не число! ")
    }
}


/**
 * Демонстрация работ банковского терминала
 *
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