/**
 * 
 */
package br.ufrn.telefoneme.util;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author Marciel Leal
 *
 */
public class Graph<T>{
	private TreeMap<Vertex<T>,ArrayList<Vertex<T>>> adj;

	public Graph(){
		this.adj=new TreeMap<>();
	}
	public boolean addVertex(Vertex<T> vertex, ArrayList<Vertex<T>> adjacents){
		if(vertex!=null&&adjacents!=null){
			adj.put(vertex, adjacents);
		}return false;
	}
	
	/*
	public boolean addVertex(Vertex<T> vertex){
		if(vertex!=null){
			return this.addVertex(vertex, new ArrayList<Vertex<T>>());
		}return false;
	}*/
	
	public boolean removeVertex(Vertex<T> vertex){
		if(vertex!=null){
			return adj.put(vertex, new ArrayList<Vertex<T>>()) != null;
		}return false;
	}
	
}
