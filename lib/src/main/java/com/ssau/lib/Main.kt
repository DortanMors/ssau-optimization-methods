package com.ssau.lib

import com.ssau.lib.lab1.Dichotomy
import com.ssau.lib.lab1.Fibonacci
import com.ssau.lib.lab1.GoldSection
import com.ssau.lib.lab1.MinFinder
import kotlin.math.abs
import kotlin.math.pow

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val minX = -3
            val lab1: List<MinFinder> = listOf(Dichotomy(), GoldSection(), Fibonacci())
            for (method: MinFinder in lab1) {
                val resultX = method.findMin({ x -> (x + 3).pow(2) }, -5.0, 0.0, 0.0001)
                println("result $resultX error = ${abs(resultX - minX)} by ${method.javaClass}")
            }
        }
    }
}