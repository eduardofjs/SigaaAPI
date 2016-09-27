package br.ufrn.telefoneme.organize;

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
				return new Manha(new Tarde());
			}else if(turno.equals("TN")){
				return new Tarde(new Noite());
			}else if(turno.equals("MN")){
				return new Manha(new Noite());
			}
		}
		return null;
		//TODO Excecao?
	}

}
