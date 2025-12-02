package search

import java.util.ArrayDeque

fun bfsGraph(startNode: Int, adjacencyList: List<List<Int>>): List<Int> {
    val nodeCount = adjacencyList.size
    val visitedNodes = BooleanArray(nodeCount)
    val nodeQueue = ArrayDeque<Int>()
    val visitOrder = mutableListOf<Int>()

    visitedNodes[startNode] = true
    nodeQueue.add(startNode)

    while (nodeQueue.isNotEmpty()) {
        val currentNode = nodeQueue.removeFirst()
        visitOrder.add(currentNode)

        for (neighborNode in adjacencyList[currentNode]) {
            if (!visitedNodes[neighborNode]) {
                visitedNodes[neighborNode] = true
                nodeQueue.add(neighborNode)
            }
        }
    }

    return visitOrder
}
