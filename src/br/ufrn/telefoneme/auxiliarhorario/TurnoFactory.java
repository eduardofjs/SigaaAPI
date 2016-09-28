package br.ufrn.telefoneme.auxiliarhorario;

public class TurnoFactory {

	public TurnoFactory() {
		//Empty
	}
	
	public Turno geraTurno(String turno){
		
		if(turno!=null){
			if(turno.equals("M")){
				return new Manha();
			}else if(turno.equals("T")){
				return new Tarde();
			}else if(turno.equals("N")){
				return new Noite();
			}else if(turno.equals("MT")){
				return new Manha();
			}else if(turno.equals("TN")){
				return new Tarde();
			}else if(turno.equals("MN")){
				return new Manha();
			}else if(turno.equals("MTN")){
				return new Manha();
			}
		}
		return null;
		//TODO Excecao?
	}

}
