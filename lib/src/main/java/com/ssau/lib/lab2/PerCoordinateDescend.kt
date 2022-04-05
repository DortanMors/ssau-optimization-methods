package com.ssau.lib.lab2

import com.ssau.lib.Logger
import kotlin.math.abs

class PerCoordinateDescend : MinFinderN {
    override fun findMinN(f: (x: Vector) -> Double, x0: Vector, x1: Vector, eps: Double): Vector {
        val dichotomyN = DichotomyN()
        var a: Vector = x0.toVec()
        var b: Vector = x0.toVec()

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
            b = dichotomyN.findMinN(f, a, b, eps).toVec()
            a = b.toVec()
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