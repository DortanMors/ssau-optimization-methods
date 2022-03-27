package com.ssau.lib.lab2


class DichotomyN : MinFinderN {
    override fun findMinN(f: (x: Vec) -> Double, x0: Vec, x1: Vec, eps: Double)
    : Vec {
        var start = x0
        var end = x1
        val dir = calcDir(start, end)
        var i = 0
        while (i < 1/eps) {
            if ((end - start).abs() < eps) break
            val xc = (start + end) * 0.5
            if (f(xc + dir * eps) > f(xc - dir * eps))
                end = xc
            else
                start = xc
            ++i
        }
        println("$i iterations")
        return (start + end) * 0.5
    }
}