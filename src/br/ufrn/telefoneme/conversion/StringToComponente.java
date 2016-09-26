/**
 * 
 */
package br.ufrn.telefoneme.util;

import java.util.ArrayList;
import java.util.List;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;

/**
 * @author Marciel Leal
 * 
 */
public class StringToComponente {

	private static StringToComponente instance=new StringToComponente();
	
	private StringToComponente() {
		// TODO Auto-generated constructor stub
	}
	
	public static StringToComponente getInstance(){
		return instance;
	}
	
	private ArrayList<String> tokenizeStringOfComponents(String components){
		ArrayList<String> tokens=new ArrayList<>();
		
		String buffer="";
		for(Character c: components.toCharArray()){
			if(c.equals('(')){
				//tokens.add("(");
			}else if(c.equals(')')){
				//tokens.add(")");
			}else if(c.equals('E')){
				//buffer+="E";
			}else if(c.equals('O')||c.equals('U')){
				//buffer+="O";
			}else if(c.equals(' ')){
				if(!buffer.isEmpty()){
					tokens.add(buffer);
				}
				buffer="";
			}else{
				buffer+=c;
			}
		}
		return tokens;
	} 
	/**
	 * Gera uma lista de componetes a partir de uma expressão de componentes 
	 * @param componentes String contendo uma expressão de componentes
	 * @return Componentes gerados pelo método
	 */
	public List<ComponenteCurricularDTO> getComponentes(String componentes){
		List<ComponenteCurricularDTO> novosComponentes=new ArrayList<>();
		List<ComponenteCurricularDTO> compOn=FachadaDeDados.getInstance().getComponentes();
		
		ComponenteCurricularDTO auxiliar=null; 
		for(String comp:tokenizeStringOfComponents(componentes)){
			auxiliar= new ComponenteCurricularDTO();
			auxiliar.setCodigo(comp);
			if(compOn.contains(auxiliar)){
				novosComponentes.add(auxiliar);
			}
		}
		return novosComponentes;
	}

}
