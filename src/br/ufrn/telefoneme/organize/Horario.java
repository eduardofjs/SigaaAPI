/**
 * 
 */
package br.ufrn.telefoneme.organize;

/**
 * @author leal
 *
 */
public class Horario implements Comparable{
	public enum Turno{ M,T,N }
	private int dia;
	private Turno turno;
	private int horarioDoDia;
	
	public Horario(int dia, Turno turno, int horarioDoDia){
		this.dia = dia;
		this.turno = turno;
		this.horarioDoDia = horarioDoDia;
	}
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public int getHorarioDoDia() {
		return horarioDoDia;
	}
	public void setHorarioDoDia(int horarioDoDia) {
		this.horarioDoDia = horarioDoDia;
	}
	
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Horario){
			Horario outrohor=(Horario) o;
			if(this.dia==outrohor.getDia()
					&&this.turno==outrohor.getTurno()
					&&this.getHorarioDoDia()==outrohor.getHorarioDoDia()){
				return true;
			}
		}return false;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Horario){
			Horario outrohor=(Horario) o;
			if(this.dia<outrohor.getDia()
					||(this.dia<outrohor.getDia()&&this.turno.compareTo(outrohor.getTurno())==-1)
					||(this.dia<outrohor.getDia()&&this.turno.compareTo(outrohor.getTurno())==-1)&&this.getHorarioDoDia()<outrohor.getHorarioDoDia()
					){
				return -1;
			}else if(this.equals(outrohor)){
				return 0;
			}
		}
		return 1;
	}
	
}
