package br.ufrn.telefoneme.connection;

import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;

public interface AbstractConnection {

	public String getTurmas(String string,String ano, String periodo) throws ConnectionException;
    
    public String getCursos(String nivel) throws ConnectionException;
    
    public String getMatrizCurricular(Integer idCurso)throws ConnectionException,IdException;
    
    public String getComponentes(Long idCurriculo) throws ConnectionException,IdException;
    
    public String getEstatisticas(String nivel, String codigo) throws ConnectionException;
    
    public String getAvaliacaoInstitucionalDocente(Integer idUnidade, Integer ano, Integer periodo) throws ConnectionException,IdException;
    
    public String getUnidadesAcademicas(String nome) throws ConnectionException;
    
    public String getAvaliacoesInstitucionaisDocentes(Integer codigoUnidade, Integer ano, Integer periodo) throws ConnectionException;
}
