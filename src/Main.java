import java.io.IOException;
import java.util.ArrayList;

import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class Main {
	private static ArrayList<String> tokenizeStringOfComponents(String components){
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

	
	
	public static void main(String[] args) throws IdException, JsonStringInvalidaException, ConexaoException, CargaHorariaDesconhecidaException, IOException {
		//System.out.println(tokenizeStringOfComponents(" ( ( DIM0052 ) E ( DIM0301 OU DIM0053 ) )"));
		//TelaCursos.main(args);
		//String j= new APIConnection().getEstatisticas("graduacao", "IMD0030");
		
		//new LocalDBCreator().createComponentesDBByMatrizId();
		
		for(CursoDTO curso: FachadaDeDados.getInstance().getCursos()){
			
				System.out.println(curso.getCurso()+ "   "+curso.getIdCurso());
				
				for(MatrizCurricularDTO matriz:FachadaDeDados.getInstance().getMatrizes(curso.getIdCurso()))
					System.out.println(matriz.getNome()+ "   "+matriz.getIdCurriculo());
		}

		//System.out.println(JsonToObject.toEstatisticasTurmasDTO(j).get(5));
		//FachadaDeDados fac=FachadaDeDados.getInstance();
		//fac.getMatrizes(idCurso)
		//SugestaoDeHorario a =new SugestaoDeHorario(matriz, componentesDaGrade);
	}
}
