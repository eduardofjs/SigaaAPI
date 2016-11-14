package br.ufrn.telefoneme.connection;

import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;

public interface AbstractConnection {

	public String getTurmas(String string,String ano, String periodo) throws ConexaoException;
    
    public String getCursos() throws ConexaoException;
    
    public String getMatrizCurricular(Integer idCurso)throws ConexaoException,IdException;
    
    public String getComponentes(Long idCurriculo) throws ConexaoException,IdException;
    
    public String getEstatisticas(String nivel, String codigo) throws ConexaoException;
    
    public String getAvaliacaoInstitucionalDocente(Integer idUnidade, Integer ano, Integer periodo) throws ConexaoException,IdException;
    
    public String getUnidadesAcademicas(String nome) throws ConexaoException;
    
    public String getAvaliacoesInstitucionaisDocentes(Integer codigoUnidade, Integer ano, Integer periodo) throws ConexaoException;
}
