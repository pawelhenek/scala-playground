package com.github.pawelhenek.scalaplayground.tour_of_scala

object innerClasses extends App {

  class Graph {
    class Node {
      var connectedNodes : List[Node] = Nil
      def connectTo(node: Node): Unit = {
        if (connectedNodes.find(node.equals).isEmpty) {
          connectedNodes = node :: connectedNodes
        }
      }
    }

    var nodes: List[Node] = Nil
    def newNode: Node = {
      val res = new Node
      nodes = res :: nodes
      res
    }
  }

  val graph1 : Graph = new Graph
  val node1 : graph1.Node = graph1.newNode
  val node2 : graph1.Node = graph1.newNode
  val node3 : graph1.Node = graph1.newNode

  node1.connectTo(node2)
  node3.connectTo(node1)

  val graph2 : Graph = new Graph
  val node4 : graph2.Node = graph2.newNode
  // this brakes the compilation
//  node1.connectTo(node4)

  class AnotherGraph {
    class Node {
      var connectedNodes: List[AnotherGraph#Node] = Nil
      def connectTo(node: AnotherGraph#Node): Unit = {
        if (connectedNodes.find(node.equals).isEmpty) {
          connectedNodes = node :: connectedNodes
        }
      }
    }
    var nodes: List[Node] = Nil
    def newNode: Node = {
      val res = new Node
      nodes = res :: nodes
      res
    }
  }
}
