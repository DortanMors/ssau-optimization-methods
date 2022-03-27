package com.ssau.lib.lab2

import kotlin.math.sqrt

typealias Vec = List<Double>

fun calcDir(a: Vec, b: Vec) =
    (b - a).normalized()

operator fun Vec.plus(v: Double) = map { it + v }

operator fun Vec.times(v: Double) = map { it * v }

operator fun Vec.plus(vec: Vec) = zip(vec).map { (l, r) -> l + r }

operator fun Vec.minus(vec: Vec) = zip(vec).map { (l, r) -> l - r }

fun Vec.abs() = sqrt(map { it * it }.sum())

fun Vec.normalized() =
    (1 / abs()).let { norm -> map { it * norm } }
