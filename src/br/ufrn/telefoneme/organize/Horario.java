package br.ufrn.telefoneme.organize;

import br.ufrn.telefoneme.componente.Componente;

/**
 * @author Marciel Leal
 *
 */
public class Horario{
	private Dia dia;
	private TurnoTemplate turno;
	private Integer horarioDoDia;
	private boolean isLivre;
	private Componente componente;
	
	public Horario(Dia dia, TurnoTemplate turno, Integer horarioDoDia){
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
	public TurnoTemplate getTurno() {
		return turno;
	}
	public void setTurno(TurnoTemplate turno) {
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
	public void ocupaHorario(Componente componente){
		this.componente=componente;
		isLivre=false;
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
	
}
