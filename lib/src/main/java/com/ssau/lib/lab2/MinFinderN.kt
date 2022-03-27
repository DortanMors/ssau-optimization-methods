package com.ssau.lib.lab2

interface MinFinderN {
    fun findMinN(f: (x: Vec) -> Double, x0: Vec, x1: Vec, eps: Double): Vec
}