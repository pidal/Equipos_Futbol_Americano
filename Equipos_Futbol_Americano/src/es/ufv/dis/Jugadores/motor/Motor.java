package es.ufv.dis.Jugadores.motor;


import java.util.Vector;

import es.ufv.dis.Jugador.bean.Jugador;
import es.ufv.dis.Jugadores.dao.Dao;

public class Motor {


	public Vector<Jugador> getJugadores()
	{
		
		Dao dao = new Dao();
		dao.leeJugadores();;
		return dao.getJugadores();
		
		
		
	}
	
	public Vector<Jugador> getJugadores(String  nombre)
	{
		
		Dao dao = new Dao();
		dao.leeJugadores();
		Vector<Jugador> als = dao.getJugadores();
		Vector<Jugador> resultado = new Vector<Jugador>();
		;
		
		
		   for(int i=0; i<als.size(); i++){
				
				Jugador jugador = als.elementAt(i);
				if(jugador.getNombre().equalsIgnoreCase(nombre)){
					
					resultado.addElement(jugador);
				}
			}
		
		
		return resultado;
		
		
	}
	

}

