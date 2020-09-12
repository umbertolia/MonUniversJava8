package hdn.pylomorphisme.utils;

import java.util.ArrayList;
import java.util.List;

import hdn.pylomorphisme.abstraction.ObjetStellaire;
import hdn.pylomorphisme.constantes.OBJET_TYPE;
import hdn.pylomorphisme.entites.Planete;
import hdn.pylomorphisme.exception.UniversException;

/**
 * classe qui simule des services
 *
 */
public class UniversUtils {
	
	
	// methode util. qui genere un nombre entre un min et un max via la fonction Random
	public static int getNombreAlea(int min, int max) {
		// TODO 
		return 0;
	}
	
	
	
	/**
	 * 	RG : nombre d'etoiles : lecture de conf.properties (doit etre situé entre un min et un max : nombre généré aléatoirement par le systeme)
	 *	RG : on ne creer pas une autre etoile qui existe deja -> redéfinir equals : etoile identique si les libelles sont identiques)
	 * 
	 */
	public static List<ObjetStellaire> creerEtoiles() throws UniversException {
		// TODO lecture de conf.properties
		
		// TODO utilisation de la IFactory
		return null;
	}
	
	

	/**
	 * retourne l'env. d'une etoile = une potentielle etoile compagnon (déterminé par le systeme) et des planetes
	 * 		mettre l'indicateur estEtoilePrincipale à true si presence d'une etoile compagnon
	 * 		RG : nombre planete situé entre 0 et NBR_PLANETES_MAX
	 * 		RG : libelle planete = concatenation nom_etoile + "_Planete" + N où N est l'indice
	 * 			exemple d'une etoile avec 2 planetes : "soleil_Planete1","soleil_Planete2" 
	 * 		RG : le systeme alimente aleatoirement le boolean Planete.estGazeuse
	 * 		RG : creation (optionnel) d'une etoile : c'est l'etoile compagnon 
	 */
	public static List<ObjetStellaire> creerEnvironnementEtoile() throws UniversException {
		// TODO lecture de conf.properties pour le nom de l'etoile compagnon
		
		// TODO utilisation de la IFactory
		List<ObjetStellaire> liste = new ArrayList<ObjetStellaire>();
		liste.add(new Planete(OBJET_TYPE.PLANETE, "P1"));
		
		
		return liste;
	}

	/**
	 * retourne l'env. d'une planete = liste de lunes 
	 * 
	 * 		RG : libelle lune = concatenation nom_planete + "_Lune" + N où n est l'indice
	 * 			exemple d'une etoile avec 2 lunes : "soleil_Lune1","soleil_Lune2" 
	 */
	public static List<ObjetStellaire> creerEnvironnementPlanete() throws UniversException {
		// TODO utilisation de la IFactory
		return null;
	}
	
	
}
