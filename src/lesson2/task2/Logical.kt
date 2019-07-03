@file:Suppress("UNUSED_PARAMETER")
package lesson2.task2

import lesson1.task1.quadraticRootProduct
import lesson1.task1.sqr
import kotlin.math.*

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean
{
    if((number%10+(number/10)%10)==((number/100)%10+(number/1000)%10)) return true else return false
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    if((x1==x2)or(y1==y2)) return true
    else
    {
        if((abs(x1-x2))==(abs(y1-y2))) return true else return false
    }
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int{
    var y=0
    if((year%4==0)&&((year%100!=0)or(year%400==0))) y=1
    if(month==2) return 28+y
    if((month==1)or(month==3)or(month==5)or(month==7)or(month==8)or(month==10)or(month==12)) return 31
    else return 30
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean{
    if((sqr((x1 - x2)) + sqr((y1- y2)) <= sqr(r2))) {
        if((sqrt(sqr(x1-x2)+ sqr(y1-y2))+r1)<=r2) return true
        else return false
    }else return false
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    if((a<=r)&&((b<=s)or(c<=s))) return true
        else {
            if((c<=r)&&((b<=s)or(a<=s))) return true
        else {
            if((b<=r)&&((a<=s)or(c<=s))) return true
                 else return false
        }
    }

}
