import br.ufrn.telefoneme.auxiliarhorario.GeraTabelaDeTurno;
import br.ufrn.telefoneme.connection.Connection;
import br.ufrn.telefoneme.connection.JsonToObject;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;
import br.ufrn.telefoneme.organize.SugestaoDeHorario;
import br.ufrn.telefoneme.windows.TelaCursos;

public class Main {

	public static void main(String[] args) throws IdException, JsonStringInvalidaException, ConexaoException, CargaHorariaDesconhecidaException {
		//TelaCursos.main(args);
		//System.out.println(OltuJavaClient.getUnidadesAcademicas("INSTITUTO METROPOLE DIGITAL"));
		//System.out.println(OltuJavaClient.getTurmas("110005","2015","2"));
		String j=Connection.getEstatisticas("graduacao", "IMD0028");
		System.out.println(j);
		System.out.println(JsonToObject.toEstatisticasTurmasDTO(j).get(5));
		//FachadaDeDados fac=FachadaDeDados.getInstance();
		//fac.getMatrizes(idCurso)
		//SugestaoDeHorario a =new SugestaoDeHorario(matriz, componentesDaGrade);
	}
}
