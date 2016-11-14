package br.ufrn.telefoneme.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;

import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.ConexaoException;
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
	
	public void createCursosDB() throws IOException, ConexaoException{
		escrever("CURSOS",new APIConnection().getCursos());
	}
	
	public void createMatrizesDBByCursoName() throws JsonStringInvalidaException, ConexaoException, IdException, IOException{
		File caminho=novoDiretorio("MatrizesByCursoName");
		for(CursoDTO curso:FachadaDeDados.getInstance().getCursos()){
			String jsonMatriz=new APIConnection().getMatrizCurricular(curso.getIdCurso());
			escrever(caminho.getPath()+"/"+curso.getCurso(),jsonMatriz);
		}
	}
	
	public void createMatrizesDBByCursoId() throws JsonStringInvalidaException, ConexaoException, IdException, IOException{
		File caminho=novoDiretorio("MatrizesByCursoId");
		for(CursoDTO curso:FachadaDeDados.getInstance().getCursos()){
			String jsonMatriz=new APIConnection().getMatrizCurricular(curso.getIdCurso());
			escrever(caminho.getPath()+"/"+curso.getIdCurso(),jsonMatriz);
		}
	}
	public void createComponentesDBByMatrizId() throws JsonStringInvalidaException, ConexaoException, IdException, IOException{
		File caminho=novoDiretorio("ComponentesByMatrizId");
		for(CursoDTO curso:FachadaDeDados.getInstance().getCursos()){
			for(MatrizCurricularDTO matriz:FachadaDeDados.getInstance().getMatrizes(curso.getIdCurso())){
				String jsonMatriz=new APIConnection().getComponentes(matriz.getIdCurriculo());
				escrever(caminho.getPath()+"/"+matriz.getIdCurriculo(),jsonMatriz);
			}
		}
	}
}
