package es.ufv.dis.Jugadores.dao;


import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import es.ufv.dis.Jugador.bean.Jugador;

public class Dao {
	
	private Vector<Jugador> Jugadores = new Vector<Jugador>();
	private static Dao _dao; //objeto de la clase
	
	public static Dao getInstance()	{
		
		if(_dao == null) //Si no esta el _dao lo crearemos a partir del if
		{
			_dao = new Dao();
			_dao.leeJugadores();
			
		}
		return _dao; //devuelvo el objeto de la clase
		
	}
	
	//utilizar solo una  variable y no crear dos variables iguales
	
	private Document generaDOM() { 
		//generamos el Document Object Model
		Document doc = null;
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();   
		DocumentBuilder docBuilder = null;
		try {
			//crear los elementos del elemento madre y luego incluirlos en el raiz
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
			Element raiz = doc.createElement("Jugadores");
			for(int i = 0; i < Jugadores.size(); i++) {
				
				Jugador jugador = Jugadores.elementAt(i);
				Element jugadorElement = doc.createElement("jugador");
				
				Element nombreElement = doc.createElement("nombre");
				nombreElement.setTextContent(jugador.getNombre());
				
				Element apellidosElement = doc.createElement("apellidos");
				apellidosElement.setTextContent(jugador.getApellidos());
				
				Element equipoElement = doc.createElement("equipo");
				equipoElement.setTextContent(jugador.getEquipo());
				
				Element posicionElement = doc.createElement("posicion");
				posicionElement.setTextContent(jugador.getPosicion());
				equipoElement.setAttribute("dorsal", jugador.getDorsal());
				
				Element salarioElement = doc.createElement("salario");
				salarioElement.setTextContent(jugador.getSalario());
				
				//a�adimos los elementos al alumno
				
				jugadorElement.appendChild(nombreElement);
				apellidosElement.appendChild(apellidosElement);
				equipoElement.appendChild(equipoElement);
				posicionElement.appendChild(posicionElement);
				salarioElement.appendChild(salarioElement);
				
				raiz.appendChild(jugadorElement);
				
				
			}
			doc.appendChild(raiz);
		}

		catch (Exception e) {
			
		}
		return doc;
	}
	
	private void guardarFicheroXML(Document doc) {
		try{
			
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Result output = new StreamResult(new File("NuevosJugadores.xml"));
		Source input = new DOMSource(doc);
		transformer.transform(input, output);
		//escribir en fichero texto el xml
		//buscar en google para pegarlo 
		}
		
		catch(Exception e){
			
			
		}
	}
	
	public void escribir() {
		Document doc = generaDOM();
		guardarFicheroXML(doc);		
	}
	
	public void leeJugadores() {

		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();   
		DocumentBuilder docBuilder = null;
		Document doc = null;
	
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse (new File("D:/Ufv/Eclipse/Equipos_Futbol_Americano/src/xml/Jugadores.xml"));
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
	
	public Vector<Jugador> getJugadores() {
		return Jugadores;
	}
	
	public void inserta(Jugador jugador) {
		this.Jugadores.addElement(jugador);
	}


}



