/**
 * 
 */
package br.ufrn.telefoneme.util;

import java.util.ArrayList;

/**
 * Representa um Vertice de um Grafo
 * @author Marciel Leal
 * 
 */
public class Vertex<T> implements Comparable<T>{
	private T value;
	private ArrayList<Vertex<T>> parents=null;
	
	public Vertex(T value){
		this.value=value;
		this.parents=new ArrayList<>();
	}
	public Vertex(T value,Vertex<T> parent){
		this.value=value;
		this.parents=new ArrayList<>();
		this.parents.add(parent);
	}

	public T getValue(){
		return this.value;
	}
	
	public void setValue(T value){
		this.value=value;
	}
	public ArrayList<Vertex<T>> getParents(){
		return this.parents;
	}
	public String toString(){
		return "Vertex= {"+this.value+","+this.parents+"}";
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o){
		if(o instanceof Vertex){
			try{
				return value.equals(((Vertex<T>)o).getValue());
			}catch(Exception e){
				return false;
			}
		}return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Object o) {
		if(o instanceof Vertex && value instanceof Comparable){
			return ((Comparable<T>)value).compareTo(((Vertex<T>)o).getValue());
		}
		return 0;
	}
	
}