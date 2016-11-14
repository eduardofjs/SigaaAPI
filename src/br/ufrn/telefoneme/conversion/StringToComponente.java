/**
 * 
 */
package br.ufrn.telefoneme.conversion;

import java.util.ArrayList;
import java.util.List;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

/**
 * @author Marciel Leal
 * 
 */
public class StringToComponente {
	
	public StringToComponente() {
		// Empty
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
	 * @throws JsonStringInvalidaException 
	 * @throws IdException 
	 * @throws ConexaoException 
	 */
	public List<ComponenteCurricularDTO> getComponentes(String componentes, Long idCurriculo)
			throws ConexaoException, IdException, JsonStringInvalidaException {
		
		List<ComponenteCurricularDTO> novosComponentes = new ArrayList<>();
		if (componentes != null) {
			if (!componentes.isEmpty()) {
				List<ComponenteCurricularDTO> compsNoBanco = FachadaDeDados.getInstance().getComponentes(idCurriculo);

				for (ComponenteCurricularDTO compNoBanco : compsNoBanco) {
					for (String comp : tokenizeStringOfComponents(componentes)) {
						if (compNoBanco.getCodigo().equals(comp)) {
							novosComponentes.add(compNoBanco);
						}
					}
				}
			}
		}
		return novosComponentes;
	}
}
