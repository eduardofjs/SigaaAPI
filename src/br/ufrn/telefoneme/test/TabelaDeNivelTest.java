package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufrn.telefoneme.organize.TabelaDeNivel;

public class TabelaDeNivelTest {

	@Test
	public void test() {
		ArrayList<TabelaDeNivel> array=new ArrayList<>();
		TabelaDeNivel t=new TabelaDeNivel(12, new ArrayList<>());
		
		assertTrue(t.equals(12));
		assertTrue(t.equals(new TabelaDeNivel(12, new ArrayList<>())));
		assertFalse(t.equals(13));
		assertFalse(t.equals(new TabelaDeNivel(13, new ArrayList<>())));
		
		array.add(new TabelaDeNivel(12, new ArrayList<>()));
		array.add(new TabelaDeNivel(14, new ArrayList<>()));
		array.add(new TabelaDeNivel(12, new ArrayList<>()));
		
		assertTrue(array.contains(new TabelaDeNivel(14, new ArrayList<>())));
		assertTrue(array.contains(new TabelaDeNivel(12, new ArrayList<>())));
		assertFalse(array.contains(new TabelaDeNivel(13, new ArrayList<>())));
		
	}

}
