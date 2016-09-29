package br.ufrn.telefoneme.auxiliarhorario;

import java.util.ArrayList;
import java.util.List;

public class Semana {
	private final List<Dia> dias;
	
	public Semana(Dia inicial, Dia fin) {
		dias=new ArrayList<Dia>();
		for(int i=inicial.getDia();i<=inicial.getDia();i++)
			dias.add(new Dia(i));
	}
	
	public List<Dia> getDias(){
		return dias;
	}

}
