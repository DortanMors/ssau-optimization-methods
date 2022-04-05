package com.ssau.lib

import com.ssau.lib.lab2.*
import com.ssau.lib.lab2.abs
import com.ssau.lib.lab2.minus
import com.ssau.lib.lab2.Vector
import kotlin.math.pow

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val minX: Vector = mutableListOf(0.0, 0.0)
            val methods = listOf(
                DichotomyN(),
                GoldenRatioN(),
                FibonacciN(),
                PerCoordinateDescend()
            )
            methods.forEach { method ->
                val resultX = method.findMinN(
                    { v: Vector -> v[0].pow(2) + v[1].pow(2) },
                    mutableListOf(-1.5, -1.5),
                    mutableListOf(1.0, 1.0),
                    0.01
                )
                println("result $resultX error = ${(resultX - minX).abs()} by ${ method.javaClass.simpleName }")
            }
        }
    }
}