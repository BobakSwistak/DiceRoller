package engine.geometry

data class Triangle(val a: Point, val b: Point, val c: Point) {
    fun edges(): List<Edge> {
        return listOf(
            Edge(a, b),
            Edge(b, c),
            Edge(c, a)
        )
    }
}


