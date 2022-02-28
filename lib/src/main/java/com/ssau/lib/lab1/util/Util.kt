package com.ssau.lib.lab1.util

fun getFibonacciNumber(n: Int): Int {
    var fib = 1
    var prevFib = 1
    for (j in 1..n) {
        val t = fib
        fib += prevFib
        prevFib = t
    }
    return fib
}

fun getNearestFibonacciPos(x: Double): Int {
    var i = 1
    var fib = 1
    var prevFib = 1
    while (fib < x) {
        fib += prevFib
        prevFib = fib - prevFib
        ++i
    }
    return i
}

