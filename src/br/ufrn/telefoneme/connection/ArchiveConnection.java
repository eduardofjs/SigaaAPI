package br.ufrn.telefoneme.connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;

public class ArchiveConnection implements AbstractConnection {
	private final String cursos="CursosByNivel";
	private final String matrizes="MatrizesByCursoID";
	private final String componentes="ComponentesByMatrizId";
	private final String estatisticas="Estatisticas";
		
	private FileReader in =null;
	
	public ArchiveConnection() {
		//Empty
	}

	private String ler(String arquivo) throws ConnectionException{
		String linha ="";
		try{
			in = new FileReader(arquivo); 
			BufferedReader lerArq = new BufferedReader(in); 
			String s;
					
			while ((s=lerArq.readLine())!=null)
				linha+=s;
			
			in.close();
		} catch (IOException e) {
			throw new ConnectionException(); 
		}
		finally{
			if(in!=null)
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("Problemas ao fechar arquivo");
				}
		}
		return linha;
	}
	
	@Override
	public String getTurmas(String string, String ano, String periodo) throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCursos(String nivel) throws ConnectionException {
		File font=new File(cursos+"/"+nivel);
		if(font.exists()){
			return ler(font.getPath());
		}
		else throw new ConnectionException();
	}

	@Override
	public String getMatrizCurricular(Integer idCurso) throws ConnectionException, IdException {
		File font=new File(matrizes+"/"+idCurso);
		if(font.exists()){
			return ler(font.getPath());
		}
		else throw new ConnectionException();
	}

	@Override
	public String getComponentes(Long idCurriculo) throws ConnectionException, IdException {
		File font=new File(componentes+"/"+idCurriculo);
		if(font.exists()){
			return ler(font.getPath());
		}
		else throw new ConnectionException();
	}

	@Override
	public String getEstatisticas(String nivel, String codigo) throws ConnectionException {
		//TODO So esta para IMD
		//TODO Estatisticas FachadaDeDados.getEstatisticas
		if(codigo.contains(".")) return "";
		File font=new File(estatisticas+"/"+codigo);
		if(font.exists()){
			return ler(font.getPath());
		}
		else throw new ConnectionException();
	
	}

	@Override
	public String getAvaliacaoInstitucionalDocente(Integer idUnidade, Integer ano, Integer periodo)
			throws ConnectionException, IdException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnidadesAcademicas(String nome) throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAvaliacoesInstitucionaisDocentes(Integer codigoUnidade, Integer ano, Integer periodo)
			throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

}
