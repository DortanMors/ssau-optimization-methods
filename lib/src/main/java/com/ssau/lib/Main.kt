package com.ssau.lib

import com.ssau.lib.lab2.DichotomyN
import com.ssau.lib.lab2.Vec
import com.ssau.lib.lab2.abs
import com.ssau.lib.lab2.minus

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val minX: Vec = mutableListOf(0.0, 0.0)
            val method = DichotomyN()
            val resultX = method.findMinN(
                { (x, y) -> x*x + y*y },
                mutableListOf(-1.5, -1.5),
                mutableListOf(1.0, 1.0),
                0.01
            )
            println("result $resultX error = ${(resultX - minX).abs()} by ${ method.javaClass.simpleName }")
        }
    }
}