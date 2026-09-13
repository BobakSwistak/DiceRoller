package engine.geometry

import kotlin.math.abs

object Geometry {

    fun orient(a: Point, b: Point, c: Point): Long {
        return (b.x - a.x).toLong() * (c.y - a.y).toLong() -
                (b.y - a.y).toLong() * (c.x - a.x).toLong()
    }

    fun inCircleCCW(a: Point, b: Point, c: Point, p: Point): Boolean {
        val ax = (a.x - p.x).toLong()
        val ay = (a.y - p.y).toLong()
        val bx = (b.x - p.x).toLong()
        val by = (b.y - p.y).toLong()
        val cx = (c.x - p.x).toLong()
        val cy = (c.y - p.y).toLong()

        val det =
            (ax * ax + ay * ay) * (bx * cy - by * cx) -
                    (bx * bx + by * by) * (ax * cy - ay * cx) +
                    (cx * cx + cy * cy) * (ax * by - ay * bx)

        return det > 0
    }

    /** Safe incircle that handles CW / CCW triangles */
    fun inCircle(a: Point, b: Point, c: Point, p: Point): Boolean {
        return if (orient(a, b, c) > 0) {
            inCircleCCW(a, b, c, p)
        } else {
            inCircleCCW(a, c, b, p) // swap to make CCW
        }
    }
    
    fun distance(a: Point, b: Point): Double {
        return abs(a.x - b.x) + abs(a.y - b.y).toDouble()
    }
    
    fun pointBeyond(a: Point, b: Point, n: Double): Point {
        val dx = b.x - a.x
        val dy = b.y - a.y
        
        return Point(
            (b.x + dx * n).toInt(),
            (b.y + dy * n).toInt()
        )
    }
}
