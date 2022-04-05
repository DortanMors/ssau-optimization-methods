package com.ssau.lib.lab2

import com.ssau.lib.Logger
import kotlin.math.sqrt

typealias Vector = MutableList<Double>
fun vecOf(v: Collection<Double>): Vector = v.toMutableList()
fun Collection<Double>.toVec() = vecOf(this)

val phi = (1 + sqrt(5.0)) * 0.5

val reciprocalPhi = 1 / phi

fun calcDir(a: Vector, b: Vector) =
    (b - a).normalized()

operator fun Vector.plus(v: Double): Vector = map { it + v }.toVec()

operator fun Vector.times(v: Double): Vector = map { it * v }.toVec()

operator fun Vector.plus(vec: Vector): Vector = zip(vec).map { (l, r) -> l + r }.toVec()

operator fun Vector.minus(vec: Vector) = zip(vec).map { (l, r) -> l - r }.toVec()

fun Vector.abs() = sqrt(map { it * it }.sum())

fun Vector.normalized() = (1 / abs()).let { norm -> map { it * norm } }.toVec()

fun fibonacci(f: (x: Double)->Double, left: Double, right: Double, eps: Double): Double {
    var x0 = left
    var x1 = right
    if (x0 > x1) {
        val tmp = x0
        x0 = x1
        x1 = tmp
    }

    var a = x0
    var b = x1
    var dx: Double

    val maxIters: Int = closestFibonacci((b - a) / eps)

    var cntr: Int = maxIters - 1

    val fiboNachos = fibonacciNumbers(maxIters)

    while (cntr >= 2) {
        if (Math.abs(x1 - x0) < eps) break

        dx = (b - a)
        x0 = a + dx * fiboNachos[cntr - 2] / fiboNachos[cntr]
        x1 = a + dx * fiboNachos[cntr - 1] / fiboNachos[cntr]

        if (f(x0) < f(x1))
            b = x1
        else
            a = x0
        cntr--
    }
    Logger.logIters("Fibonacci", maxIters)

    return (x1 + x0) * 0.5
}

fun fibonacciNumbers(index: Int): IntArray {
    if (index < 0) return intArrayOf(0)
    if (index == 0 || index == 1) intArrayOf(1)
    return IntArray(index).also {
        it[0] = 1
        it[1] = 1
        for (i in 2 until index) it[i] = it[i - 1] + it[i - 2]
    }
}

fun closestFibonacci(value: Double): Int {
    var f1 = 1
    if (value <= 1) return f1
    var f2 = 2
    if (value <= 2) return f2

    var f3 = 3
    if (value <= 3) return f3

    var cntr = 3
    while (true) {
        f1 = f2
        f2 = f3
        f3 = f1 + f2
        if (f3 > value) return cntr
        cntr++
    }
}