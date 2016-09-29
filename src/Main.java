import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;
import br.ufrn.telefoneme.windows.TelaCursos;

public class Main {

	public static void main(String[] args) throws IdException, JsonStringInvalidaException, ConexaoException, CargaHorariaDesconhecidaException {
		TelaCursos.main(args);
	}
}
