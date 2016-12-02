package br.ufrn.telefoneme.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;

import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class LocalDBCreator {

	private void escrever(String arquivo,String texto) throws IOException{
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
	
	private File novoDiretorio(String caminho){
		File f=new File(caminho);
		if(!f.exists())
			if(f.mkdir())
				return f;
			else return null;
		else return f;
	}
	
	public void createCursosDB() throws IOException, ConnectionException{
		File caminho=novoDiretorio("CursosByNivel");
		escrever(caminho.getPath()+"/"+"GRADUACAO",new APIConnection().getCursos("GRADUACAO"));
	}
	
	public void createMatrizesDBByCursoName() throws JsonStringInvalidaException, ConnectionException, IdException, IOException{
		File caminho=novoDiretorio("MatrizesByCursoName");
		for(CursoDTO curso:FachadaDeDados.getInstance().getCursos(new APIConnection())){
			String jsonMatriz=new APIConnection().getMatrizCurricular(curso.getIdCurso());
			escrever(caminho.getPath()+"/"+curso.getCurso(),jsonMatriz);
		}
	}
	
	public void createMatrizesDBByCursoId() throws JsonStringInvalidaException, ConnectionException, IdException, IOException{
		File caminho=novoDiretorio("MatrizesByCursoId");
		for(CursoDTO curso:FachadaDeDados.getInstance().getCursos(new APIConnection())){
			String jsonMatriz=new APIConnection().getMatrizCurricular(curso.getIdCurso());
			escrever(caminho.getPath()+"/"+curso.getIdCurso(),jsonMatriz);
		}
	}
	public void createComponentesDBByMatrizId() throws JsonStringInvalidaException, ConnectionException, IdException, IOException{
		File caminho=novoDiretorio("ComponentesByMatrizId");
		for(CursoDTO curso:FachadaDeDados.getInstance().getCursos(new APIConnection())){
			for(MatrizCurricularDTO matriz:FachadaDeDados.getInstance().getMatrizes(new APIConnection(),curso.getIdCurso())){
				String jsonMatriz=new APIConnection().getComponentes(matriz.getIdCurriculo());
				escrever(caminho.getPath()+"/"+matriz.getIdCurriculo(),jsonMatriz);
			}
		}
	}
	
	public void createEstatisticaDBByComponenteCod() throws JsonStringInvalidaException, ConnectionException, IdException, IOException{
		File caminho=novoDiretorio("Estatisticas");
		//for(CursoDTO curso:FachadaDeDados.getInstance().getCursos(new APIConnection())){
			//for(MatrizCurricularDTO matriz:FachadaDeDados.getInstance().getMatrizes(new APIConnection(),105755388)){
				//if(matriz.getAtivo()){
					//System.out.println(matriz.getNome());
					for(ComponenteCurricularDTO componente:FachadaDeDados.getInstance().getComponentes(new APIConnection(),new Long(105755388))){
						if(componente.getComponentesBloco().isEmpty()){
							String jsonEstatistica=new APIConnection().getEstatisticas("GRADUACAO", componente.getCodigo());
							escrever(caminho.getPath()+"/"+componente.getCodigo(),jsonEstatistica);
						}else{
							for(ComponenteCurricularDTO comp:componente.getComponentesBloco()){
								String jsonEstatistica=new APIConnection().getEstatisticas("GRADUACAO", comp.getCodigo());
								escrever(caminho.getPath()+"/"+componente.getCodigo(),jsonEstatistica);
							}
						}
					}
				//}
			//}
		//}
	}
}
