/**
 * 
 */
package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufrn.telefoneme.organize.TabelaHorario;

/**
 * @author Marciel Leal
 *
 */
public class TabelaHorarioTest {
	private TabelaHorario tabela=new TabelaHorario(2, 7);
	
	@Test
	public void toStringTest() {
		System.out.println(tabela);
	}

}
