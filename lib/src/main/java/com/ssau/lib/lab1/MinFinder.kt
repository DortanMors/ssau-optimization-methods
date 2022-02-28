package com.ssau.lib.lab1

interface MinFinder {
    fun findMin(f: (x: Double) -> Double, a: Double, b: Double, eps: Double): Double
}