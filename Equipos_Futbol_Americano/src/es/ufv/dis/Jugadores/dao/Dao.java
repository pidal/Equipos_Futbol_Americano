package es.ufv.dis.Jugadores.dao;


import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import es.ufv.dis.Jugador.bean.Jugador;

public class Dao {
	
	private Vector<Jugador> Jugadores = new Vector<Jugador>();
	
	
	
	
	public void leeJugadores()
	{

		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();   
		DocumentBuilder docBuilder = null;
		Document doc = null;
	
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse (new File("C:/Users/Dolores00/workspace/Equipos_Futbol_Americano/src/xml/Jugadores.xml"));
			//Document doc = docBuilder.parse(Class.class.getResourceAsStream("/es/ufv/dis/ejercicio1/xml/cv.xml"));
			doc.getDocumentElement().normalize();   
			
			Element raiz = doc.getDocumentElement();
			
			NodeList hijos = raiz.getChildNodes();
			System.out.println( "El numero de hijos es "+hijos.getLength());
			
			for (int i = 0; i < hijos.getLength(); i++)
			{
				Node hijo = hijos.item(i);
				if (hijo.getNodeType() == Node.ELEMENT_NODE)
				{
					Element hijoEl = (Element)hijo;
					Node nombreNodo = hijoEl.getElementsByTagName("nombre").item(0);
					Element nombreElement = (Element)nombreNodo;
					String nombre = nombreElement.getTextContent();
					
					// String nombre = hijoEl.getElementsByTagName("nombre").item(0).getFirstChild().getNodeValue();
					
					Node apellidosNodo = hijoEl.getElementsByTagName("apellidos").item(0);
					Element apellidosElement = (Element)apellidosNodo;
					String apellidos = apellidosElement.getTextContent();
                    
					Node equipoNodo = hijoEl.getElementsByTagName("equipo").item(0);
					Element equipoElement = (Element)equipoNodo;
					String equipo = equipoElement.getTextContent();
					
					Node posicionNodo = hijoEl.getElementsByTagName("posicion").item(0);
					Element posicionElement = (Element)posicionNodo;
					String posicion = posicionElement.getTextContent();
					
					String dorsal = posicionElement.getAttribute("dorsal"); 
					
					Node salarioNodo = hijoEl.getElementsByTagName("salario").item(0);
					Element salarioElement = (Element)salarioNodo;
					String salario = salarioElement.getTextContent();
					
					
					Jugador jugador = new Jugador(nombre,apellidos,equipo,posicion,dorsal,salario);
					
					Jugadores.addElement(jugador);
					
				}
				
				
			}
			
			
		
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}
	
	
	
	public Vector<Jugador> getJugadores()
	{
		return Jugadores;
	}
	
	
	
	

}



