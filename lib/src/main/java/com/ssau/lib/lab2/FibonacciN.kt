package com.ssau.lib.lab2

import com.ssau.lib.Logger

class FibonacciN : MinFinderN {
    override fun findMinN(f: (x: Vector) -> Double, x0: Vector, x1: Vector, eps: Double): Vector {
        val maxIterations = closestFibonacci((x1 - x0).abs() / eps)
        var cntr = maxIterations - 1
        val fiboNachos = fibonacciNumbers(maxIterations)
        var left = x0
        var right = x1
        var a = x0
        var b = x1
        var dx: Vector

        while (cntr >= 2) {
            if ((b - a).abs() < eps) break
            dx  = right - left
            a = (left + (dx * (fiboNachos[cntr - 2].toDouble() / fiboNachos[cntr])))
            b = (left + (dx * (fiboNachos[cntr -1].toDouble() / fiboNachos[cntr])))
            if (f(a) < f(b))
                right = b
            else
                left = a
            --cntr
        }
        Logger.logIters(javaClass.simpleName, maxIterations)
        return (b + a) * 0.5
    }
}