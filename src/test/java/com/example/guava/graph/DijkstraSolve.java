package com.example.guava.graph;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

/**
 * Package:com.example.guava.graph
 * *Author:ray
 * *version:...
 * *Created in 2020/4/24  14:49
 **/
public class DijkstraSolve {

	private String sourceNode;

	private MutableValueGraph<String,Integer> graph;

	public DijkstraSolve() {
	}

	public DijkstraSolve(String sourceNode, MutableValueGraph<String, Integer> graph) {
		this.sourceNode = sourceNode;
		this.graph = graph;
	}

	private void initPathFromSourceNode(String sourceNode){
		//graph.nodes().stream()
		//		.filter(node ->graph.adjacentNodes())
	}

	private void printGraph(){
		for (String node : graph.nodes()) {
			System.out.println(sourceNode+"->"+node+"shortest path is"+ graph.edgeValue(sourceNode,node));
		}
	}



	private static MutableValueGraph<String,Integer> buildGraph(){

		MutableValueGraph<String,Integer> graph = ValueGraphBuilder
				.directed()
				.nodeOrder(ElementOrder.<String>natural())
				.allowsSelfLoops(true).build();
		graph.putEdgeValue("A", "B",10);
		graph.putEdgeValue("A", "C",3);
		graph.putEdgeValue("A", "D",20);
		graph.putEdgeValue("B", "D",5);
		graph.putEdgeValue("C", "B",2);
		graph.putEdgeValue("C", "E",15);
		graph.putEdgeValue("D", "E",11);
		return graph;
	}
}
