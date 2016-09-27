package br.ufrn.telefoneme.organize;

import br.ufrn.telefoneme.auxiliarhorario.Dia;
import br.ufrn.telefoneme.auxiliarhorario.Turno;
import br.ufrn.telefoneme.componente.Componente;

/**
 * @author Marciel Leal
 *
 */
public class Horario implements Comparable<Horario>{
	private Dia dia;
	private Turno turno;
	private Integer horarioDoDia;
	private boolean isLivre;
	private Componente componente;
	
	public Horario(Dia dia, Turno turno, Integer horarioDoDia){
		this.dia = dia;
		this.turno = turno;
		this.horarioDoDia = horarioDoDia;
		this.isLivre=true;
	}
	
	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public Integer getHorarioDoDia() {
		return horarioDoDia;
	}
	public void setHorarioDoDia(Integer horarioDoDia) {
		this.horarioDoDia = horarioDoDia;
	}
	public Componente getComponente(){
		return componente;
	}
	public boolean isLivre() {
		return isLivre;
	}
	public void ocupaHorario(){
		this.isLivre=false;
		
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Horario){
			Horario outrohor=(Horario) o;
			if(this.dia.equals(outrohor)
					&&this.turno.equals(outrohor.getTurno())
					&&this.horarioDoDia.equals(outrohor.getHorarioDoDia())){
				return true;
			}
		}return false;
	}

	@Override
	public int compareTo(Horario o) {
		return this.getDia().compareTo(o.getDia());
	}	
	
	
}
