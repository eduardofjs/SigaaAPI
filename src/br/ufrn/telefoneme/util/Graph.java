/**
 * 
 */
package br.ufrn.telefoneme.util;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Representa um Grafo
 * @author Marciel Leal
 * 
 */
public class Graph<T>{
	private TreeMap<T,ArrayList<T>> adj;

	public Graph(){
		this.adj=new TreeMap<>();
	}
	public void addVertex(T data){
		this.adj.put(data, new ArrayList<T>());
	}
	public void addVertex(T data, ArrayList<T> adj){
		ArrayList<T> lista= this.adj.get(data);

		if(lista!=null)
			lista.addAll(adj);
		else this.adj.put(data, adj);
	}
	public void addVetex(T data, T... adjs){
		ArrayList<T> lista= this.adj.get(data);
		ArrayList<T> param=new ArrayList<>();
		
		for (T adj:adjs)
			param.add(adj);
		
		if(lista!=null)
			lista.addAll(param);
		else this.adj.put(data, param);
	}
}
