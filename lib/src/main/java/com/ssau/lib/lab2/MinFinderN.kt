package com.ssau.lib.lab2

interface MinFinderN {
    fun findMinN(f: (x: Vector) -> Double, x0: Vector, x1: Vector, eps: Double): Vector
}