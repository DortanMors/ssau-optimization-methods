package com.ssau.lib.lab2

class Lab2 {
    companion object {
        @JvmStatic
        fun maina(args: Array<String>) {
            val minX: Vec = listOf(0.0, 0.0)
            val method = DichotomyN()
            val resultX = method.findMinN(
                { (x, y) -> x*x + y*y },
                listOf(-1.0, -1.0),
                listOf(1.0, 1.0),
                0.01
            )
            println("result $resultX error = ${ (resultX - minX).abs() } by ${ method.javaClass }")
        }
    }
}