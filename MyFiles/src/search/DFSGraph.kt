package search

fun dfsGraph(
    currentNode: Int,
    adjacencyList: List<List<Int>>,
    visitedNodes: BooleanArray,
    visitOrder: MutableList<Int>,
) {
    visitedNodes[currentNode] = true
    visitOrder.add(currentNode)

    for (neighborNode in adjacencyList[currentNode]) {
        if (!visitedNodes[neighborNode]) {
            dfsGraph(neighborNode, adjacencyList, visitedNodes, visitOrder)
        }
    }
}

