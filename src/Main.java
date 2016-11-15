import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;
import br.ufrn.telefoneme.organize.SugestaoAbrirDisciplinas;
import br.ufrn.telefoneme.util.LocalDBCreator;

public class Main {
	private static void escrever(String arquivo,String texto) throws IOException{
		FileWriter out=null;		
		
		try{
			//Escrevendo
			out = new FileWriter(arquivo); 
			PrintWriter gravarArq = new PrintWriter(out);
			gravarArq.print(texto);

		}finally{
			if(out!=null)
				out.close();
		}
	}
	public static void main(String[] args) throws IdException, JsonStringInvalidaException, ConnectionException, CargaHorariaDesconhecidaException, IOException {
		//TelaCursos.main(args);
		
		//for(CursoDTO curso: FachadaDeDados.getInstance().getCursos()){
			
			//	System.out.println(curso.getCurso()+ "   "+curso.getIdCurso());
				
				//for(MatrizCurricularDTO matriz:FachadaDeDados.getInstance().getMatrizes(curso.getIdCurso()))
					//System.out.println(matriz.getNome()+ "   "+matriz.getIdCurriculo());
		//}
		//new LocalDBCreator().createCursosDB();
		//new LocalDBCreator().createEstatisticaDBByComponenteCod();
		//System.out.println(new APIConnection().getUnidadesAcademicas("INSTITUTO METROPOLE DIGITAL"));
		//System.out.println(new APIConnection().getAvaliacaoInstitucionalDocente(110005, 2015, 2));
		//System.out.println(JsonToObject.toEstatisticasTurmasDTO(j).get(5));
		//FachadaDeDados fac=FachadaDeDados.getInstance();
		//fac.getMatrizes(idCurso)
		//SugestaoDeHorario a =new SugestaoDeHorario(matriz, componentesDaGrade);
		new SugestaoAbrirDisciplinas().gerarSugestao(2);
	}
}
