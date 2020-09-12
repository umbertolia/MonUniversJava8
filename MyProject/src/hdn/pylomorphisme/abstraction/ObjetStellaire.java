package hdn.pylomorphisme.abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import hdn.pylomorphisme.constantes.OBJET_TYPE;
import hdn.pylomorphisme.constantes.RESULT;

/**
 * classe abstraite 
 * TODO sur les classes filles ne peuvent pas avoir de sous type : mettre le mot clé correspondant
 *
 */
public class ObjetStellaire implements Runnable {
	

	private OBJET_TYPE objet_TYPE;
	private String libelle;
	private List<ObjetStellaire> environnement = new ArrayList<ObjetStellaire>();

	public ObjetStellaire(OBJET_TYPE objet_TYPE) {
		this.objet_TYPE  = objet_TYPE;
	}
	
	
	public ObjetStellaire(OBJET_TYPE objet_TYPE, String libelle) {
		this.objet_TYPE = objet_TYPE;
		this.libelle = libelle;
	}


	public List<ObjetStellaire> getEnvironnement() {
		return environnement;
	}
	
	
	public String getLibelle() {
		return libelle;
	}


	public void setEnvironnement(List<ObjetStellaire> environnement) {
		this.environnement = environnement;
	}


	@Override
	public String toString() {
		StringJoiner stringJoiner = new StringJoiner("\n");
		stringJoiner.add(getClass().getSimpleName() + " " + libelle + " de type "+objet_TYPE);	
		return stringJoiner.toString();
	}

	/**
	 * creer l'environnement sous forme de liste  (etoile double, planetes, lunes) en fonction de l'objet courant
	 * on capture l'exception et on remonte uniquement un code retour contenu dans RESULT 
	 * 
	 */
	public abstract RESULT genererEnvironnement();
}
