@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import kotlin.Double.Companion.NaN
import kotlin.math.*

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    if ((age / 10) % 10 == 1) {
        return "$age лет"
    } else
        if (age % 10 == 1) {
            return "$age год"
        } else
            if ((age % 10 == 2) or (age % 10 == 3) or (age % 10 == 4)) {
                return "$age года"
            } else return "$age лет"

}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    var vH = (t1 * v1 + t2 * v2 + t3 * v3) / 2
    var tRes = 0.00
    if (vH >= v1 * t1) {
        tRes += t1
        vH -= v1 * t1

        if (vH >= v2 * t2) {
            tRes += t2
            vH -= v2 * t2

            if (vH >= v3 * t3) {
                tRes += t3
                vH -= v3 * t3
                return tRes
            } else return tRes + vH / v3

        } else return tRes + vH / v2
    } else
        return vH / v1

}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    var res = 0;
    if ((kingX == rookX1) or (kingY == rookY1)) res += 1
    if ((kingX == rookX2) or (kingY == rookY2)) res += 2
    return res
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    var res = 0;
    if ((kingX == rookX) or (kingY == rookY)) res += 1
    if ((kingX != bishopX) or (kingY != bishopY)) {
        if (abs(kingX - bishopX) == abs(kingY - bishopY)) res += 2
    }
    return res
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    if (((a + b) > c) && ((c + b) > a) && ((a + c) > b)) {
        val alpha = abs((acos((sqr(a) + sqr(b) - sqr(c)) / (2 * a * b))) * 180 / PI)
        val beta = abs((acos((sqr(c) + sqr(b) - sqr(a)) / (2 * c * b))) * 180 / PI)
        val gamma = 180 - (alpha + beta)
        if ((alpha == 90.00) or (beta == 90.00) or (gamma == 90.00)) {
            return 1
        }
        if ((alpha > 90.00) or (beta > 90.00) or (gamma > 90.00)) {
            return 2
        } else {
            return 0
        }
    } else return -1
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    if ((b < c) or (d < a)) return -1
    else {
        if ((b>=d)&&(c>=a)) {
            return (d-c)
        }
        if ((b>=c)&&(c>=a)){
            return (b-c)
        }
        if ((b<=d)&&(c<=a)) {
            return (b-a)
        }
        if ((d<=b)&&(a>=c)){
            return (d-a)
        } else return -2
    }

}
