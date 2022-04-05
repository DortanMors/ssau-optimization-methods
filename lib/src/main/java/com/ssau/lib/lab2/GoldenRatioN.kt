package com.ssau.lib.lab2

class GoldenRatioN : MinFinderN {
    override fun findMinN(f: (x: Vector) -> Double, x0: Vector, x1: Vector, eps: Double): Vector {
        var left = x0
        var a = x0
        var right = x1
        var b = x1
        var dx: Vector
        val maxIteration = (1/eps).toInt()
        var i = 0
        while(i < maxIteration) {
            if ((b - a).abs() < eps) break
            dx = (right - left) * reciprocalPhi
            a = right - dx
            b = left + dx
            if (f(a) >= f(b))
                left = a
            else
                right = b
            ++i
        }
        println("$i iterations")
        return (a + b) * 0.5
    }
}