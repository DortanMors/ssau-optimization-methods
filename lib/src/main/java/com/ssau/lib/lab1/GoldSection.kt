package com.ssau.lib.lab1

import com.ssau.lib.Logger
import kotlin.math.abs
import kotlin.math.sqrt

class GoldSection: MinFinder {
    override fun findMin(f: (x: Double) -> Double, left: Double, right: Double, eps: Double): Double {
        var x1: Double
        var x2: Double
        var a = left
        var b = right
        var i = 1
        val phi = (1 + sqrt(5.0)) * 0.5
        while (true) {
            x1 = b - (b - a) / phi
            x2 = a + (b - a) / phi
            if (f(x2) < f(x1))
                a = x1
            else
                b = x2
            if (abs(x1 - x2) < 2 * eps) break
            if (i > 1/eps) {
                Logger.log("Not enough accuracy")
                break
            }
            ++i
        }
        println("$i iterations")
        return (a + b) * 0.5
    }
}