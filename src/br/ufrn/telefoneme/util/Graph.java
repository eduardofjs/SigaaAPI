/**
 * 
 */
package br.ufrn.telefoneme.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Representa um Grafo
 * @author Marciel Leal
 * 
 */
public class Graph<T>{
	private TreeMap<T,List<T>> adj;

	public Graph(){
		this.adj=new TreeMap<>();
	}
	public void addVertex(T key){
		this.adj.put(key, new ArrayList<T>());
	}
	public void addVertex(T key, List<T> adj){
		List<T> lista= this.adj.get(key);

		if(lista!=null)
			lista.addAll(adj);
		else this.adj.put(key, adj);
	}
	public void addVetex(T key, T... adjs){
		List<T> lista= this.adj.get(key);
		List<T> param=new ArrayList<>();
		
		for (T adj:adjs)
			param.add(adj);
		
		if(lista!=null)
			lista.addAll(param);
		else this.adj.put(key, param);
	}
	public List<T> Adj(T key){
		return this.adj.get(key);
	}
}
