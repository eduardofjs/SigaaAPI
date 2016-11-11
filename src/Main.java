import br.ufrn.telefoneme.connection.Connection;
import br.ufrn.telefoneme.connection.JsonToObject;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class Main {

	public static void main(String[] args) throws IdException, JsonStringInvalidaException, ConexaoException, CargaHorariaDesconhecidaException {
		//TelaCursos.main(args);
		String j=Connection.getEstatisticas("graduacao", "IMD0030");
		System.out.println(JsonToObject.toEstatisticasTurmasDTO(j).get(5));
		//FachadaDeDados fac=FachadaDeDados.getInstance();
		//fac.getMatrizes(idCurso)
		//SugestaoDeHorario a =new SugestaoDeHorario(matriz, componentesDaGrade);
	}
}
