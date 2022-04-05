package com.ssau.lib.lab2

import com.ssau.lib.Logger
import kotlin.math.abs

class PerCoordinateDescend : MinFinderN {
    override fun findMinN(f: (x: Vec) -> Double, x0: Vec, x1: Vec, eps: Double): Vec {
        val dichotomyN = DichotomyN()
        var a: Vec = x0.toMutableList()
        var b: Vec = x0.toMutableList()

        val step = 1.0

        var xI: Double
        var y1: Double
        var y0 : Double

        var optCoordN = 0
        var coordId: Int
        val maxIters = (1 / eps).toInt()
        var i = 0
        while (i < maxIters) {
            coordId = i % a.size
            b[coordId]
            b[coordId] -= eps
            y0 = f(b)
            b[coordId] += 2 * eps
            y1 = f(b)
            b[coordId] -= eps
            b[coordId] = if (y0 > y1) b[coordId] + step else b[coordId] - step
            xI = a[coordId]
            b = dichotomyN.findMinN(f, a, b, eps).toMutableList()
            a = b.toMutableList()
            if (abs(b[coordId] - xI) < eps) {
                optCoordN++
                if (optCoordN == b.size) {
                    Logger.logIters(javaClass.simpleName, i)
                    return a
                }
                continue
            }
            optCoordN = 0
            ++i
        }

        Logger.logIters(javaClass.simpleName, i)
        return a
    }
}