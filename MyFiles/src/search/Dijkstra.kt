package search

import java.util.*

data class Edge(val targetNode: Int, val weight: Int)
data class Node(val vertex: Int, val distance: Int)

fun dijkstraShortestPaths(
    nodeCount: Int,
    adjacencyList: List<List<Edge>>,
    sourceNode: Int,
): IntArray {
    val distanceToNode = IntArray(nodeCount) { Int.MAX_VALUE }
    distanceToNode[sourceNode] = 0

    val nodePriorityQueue = PriorityQueue<Node>(compareBy { it.distance })
    nodePriorityQueue.add(Node(sourceNode, 0))

    while (nodePriorityQueue.isNotEmpty()) {
        val (currentVertex, currentDistance) = nodePriorityQueue.poll()
        if (currentDistance != distanceToNode[currentVertex]) continue

        for (edge in adjacencyList[currentVertex]) {
            val newDistance = currentDistance + edge.weight
            if (newDistance < distanceToNode[edge.targetNode]) {
                distanceToNode[edge.targetNode] = newDistance
                nodePriorityQueue.add(Node(edge.targetNode, newDistance))
            }
        }
    }

    return distanceToNode
}

