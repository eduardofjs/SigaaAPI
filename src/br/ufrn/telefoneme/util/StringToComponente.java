/**
 * 
 */
package br.ufrn.telefoneme.util;

import java.util.ArrayList;
import java.util.Stack;

import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;

/**
 * @author Marciel Leal
 * 
 */
public class StringToComponente {

	private StringToComponente instance=new StringToComponente();
	
	private StringToComponente() {
		// TODO Auto-generated constructor stub
	}
	public StringToComponente getInstance(){
		return instance;
	}
	
	private ArrayList<String> tokenizeStringOfComponents(String components){
		ArrayList<String> componentes=new ArrayList<>();
		Stack<Character> stack=new Stack<>();
		
		for(Character c: components.toCharArray()){
			if(c.equals('(')){
				stack.push('(');
				continue;
			}else if(c.equals(')'){
				if(!stack.isEmpty()){
					stack.pop();
				}
			}else if(c.equals('E')){
				
			}
		}
	}
	
	public ArrayList<ComponenteCurricularDTO> getComponentes(String componentes){
		ArrayList<ComponenteCurricularDTO> comp=new ArrayList<>();
		
		
	}

}
