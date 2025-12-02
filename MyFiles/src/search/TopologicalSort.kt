package search

import java.util.ArrayDeque

fun topologicalSort(nodeCount: Int, adjacencyList: List<List<Int>>): List<Int> {
    val inDegree = IntArray(nodeCount)
    for (sourceNode in 0 until nodeCount) {
        for (targetNode in adjacencyList[sourceNode]) {
            inDegree[targetNode]++
        }
    }

    val nodeQueue = ArrayDeque<Int>()
    for (node in 0 until nodeCount) {
        if (inDegree[node] == 0) {
            nodeQueue.add(node)
        }
    }

    val topologicalOrder = mutableListOf<Int>()
    while (nodeQueue.isNotEmpty()) {
        val currentNode = nodeQueue.removeFirst()
        topologicalOrder.add(currentNode)

        for (neighbor in adjacencyList[currentNode]) {
            inDegree[neighbor]--
            if (inDegree[neighbor] == 0) {
                nodeQueue.add(neighbor)
            }
        }
    }

    return topologicalOrder
}

