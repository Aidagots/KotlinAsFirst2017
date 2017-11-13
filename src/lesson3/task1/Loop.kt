@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import lesson1.task1.sqr
import java.lang.Math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var n1 = n
    var count = 1
    while (abs(n1) > 9) {
        n1 = n1 / 10
        count = count + 1
    }
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var fib1 = 1
    var fib2 = 1
    var fib3 = fib1 + fib2
    if (n == 1 || n == 2) return 1
        for (h in 3..n) {
            fib3 = fib1 + fib2
            fib1 = fib2
            fib2 = fib3
        }
    return fib2

}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var m1 = m
    var n1 = n
    while (m1 != n1) {
        if (m1 > n1) n1 += n
        else m1 += m
    }
    return m1
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int  {
    var count = 2
    while (n % count != 0) {
        count=count+1
    }
    return count
}


/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var k = n / 2
    while (n % k != 0) {
        k -= 1
    }
    return k
}



/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var m1 = m
    var n1 = n
    while(m1!=n1){
        if (m1>n1) m1 -=n1 else n1-=m1
    }
    return (m1==1)
}


/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    for (b in sqrt(m.toDouble()).toInt()..sqrt(n.toDouble()).toInt()) {
        if (sqr(b.toDouble()) >= m)
            return true
    }
    return false

}



/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    var b = x
    var g = 1
    var h = x
    var k = 0.0
        while (h > 2 * PI) {
            h = h - 2 * PI
        }
        while (h < -2 * PI) {
            h += 2 * PI
        }
    if (h == 0.0) return 0.0
    while (abs(b)>=abs(eps)) {
        b = pow(h, g.toDouble()) / factorial(g)
        if (g % 4 == 3) k = k - b
        if (g % 4 == 1) k = k + b
        g += 2
    }
    return k
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var b = x
    var g = 2
    var h = x
    var k = 1.0
    if (h > 2 * PI) {
        while (h > 2 * PI) {
            h = h - 2 * PI
        }
    }
    if (h < -2 * PI) {
        while (h < -2 * PI) {
            h += 2 * PI
        }
    }
    if (h == 0.0) return 1.0
    while (abs(b)>=abs(eps)){
        b = pow(h, g.toDouble()) / factorial(g)
        if (g % 4 == 0) k = k + b
        if (g % 4 == 2) k = k - b
        g += 2
    }
    return k

}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int = TODO()

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean = TODO()

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean = TODO()

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var k: Int
    var count = 0
    var i = 0
    while (n > count) {
        i += 1
        k = i * i
        count+= digitNumber (k)
    }
    k = i * i
    if (count > n) {
        k /= pow(10.0, (count - n).toDouble()).toInt()
    }
    return k % 10
}



/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var m = 1
    var count = 1
    var h = 0
    var h1 = 1
    while (n > count) {
        m = h + h1
        count+=digitNumber(m)
        m = h + h1
        val h2 = h
        h = h1
        h1 = h2 + h
    }
    val c = count - n
    if (count > n) {
        for (j in 1..c) {
            m /= 10
        }
    }
    return m % 10
}

