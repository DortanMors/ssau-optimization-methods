package com.ssau.lib.lab1

import com.ssau.lib.Logger

class Fibonacci: MinFinder {
    override fun findMin(f: (x: Double) -> Double, left: Double, right: Double, eps: Double): Double {
        var fib1 = 1
        var fib2 = 2
        var fib3 = 3
        val Fn = (right - left) / eps
        var x1: Double
        var x2: Double
        var a = left
        var b = right
        var i = 1
        while (true) {
            x1 = a + (b - a) * fib1 / fib3
            x2 = a + (b - a) * fib2 / fib3
            if (f(x2) < f(x1))
                a = x1
            else
                b = x2
            if (fib2 + fib3 > Fn) break
            if (i > 1/eps) {
                Logger.log("Not enough accuracy")
                break
            }
            ++i
            val prevFib3 = fib3
            val prevFib2 = fib2
            fib3 += fib2
            fib2 = prevFib3
            fib1 = prevFib2
        }
        println("$i iterations")
        return (x1 + x2) * 0.5
    }
}