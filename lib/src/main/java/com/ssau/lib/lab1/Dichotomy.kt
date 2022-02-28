package com.ssau.lib.lab1

import com.ssau.lib.Logger
import kotlin.math.abs

class Dichotomy: MinFinder {
    override fun findMin(f: (x: Double) -> Double, left: Double, right: Double, eps: Double): Double {
        var x1: Double
        var x2: Double
        var a = left
        var b = right
        var i = 1
        while (true) {
            x1 = (a + b) * 0.5 - eps
            x2 = (a + b) * 0.5 + eps
            if (f(x2) < f(x1))
                a = x2
            else
                b = x1
            if (abs(x1 - x2) < 2 * eps) break
            if (i > 1/eps) {
                Logger.log("Not enough accuracy")
                break
            }
            ++i
        }
        println("$i iterations")
        return (x1 + x2) * 0.5
    }
}