/**
 * 
 */
package br.ufrn.telefoneme.auxiliarhorario;

/**
 * @author leal
 *
 */
public class Dia implements Comparable<Dia>{
	private final Integer dia;

	public Dia(Integer dia){
		this.dia=dia;
	}
	
	public Integer getDia() {
		return dia;
	}
	
	@Override
	public String toString(){
		return this.dia.toString();
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof Dia){
			Dia outroDia=(Dia)o;
			return this.dia.equals(outroDia.getDia());
		}return false;
	}

	@Override
	public int compareTo(Dia o) {
		return this.dia.compareTo(o.getDia());
	}
	
}
