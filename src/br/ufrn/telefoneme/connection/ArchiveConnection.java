package br.ufrn.telefoneme.connection;

import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;

public class ArchiveConnection implements AbstractConnection {

	public ArchiveConnection() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTurmas(String string, String ano, String periodo) throws ConexaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCursos() throws ConexaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMatrizCurricular(Integer idCurso) throws ConexaoException, IdException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getComponentes(Integer idCurriculo) throws ConexaoException, IdException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEstatisticas(String nivel, String codigo) throws ConexaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAvaliacaoInstitucionalDocente(Integer idUnidade, Integer ano, Integer periodo)
			throws ConexaoException, IdException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnidadesAcademicas(String nome) throws ConexaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAvaliacoesInstitucionaisDocentes(Integer codigoUnidade, Integer ano, Integer periodo)
			throws ConexaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
