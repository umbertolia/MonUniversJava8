package hdn.pylomorphisme.entites;

import java.util.StringJoiner;

import hdn.pylomorphisme.abstraction.ObjetStellaire;
import hdn.pylomorphisme.constantes.OBJET_TYPE;
import hdn.pylomorphisme.constantes.RESULT;
import hdn.pylomorphisme.utils.UniversUtils;

public class Planete {

	public final static int NBR_LUNES_MAX = 7;
	
	private boolean estGazeuse;

	public Planete(OBJET_TYPE objet_TYPE, String libelle) {
		super(objet_TYPE, libelle);
		// TODO alimenter estGazeuse
	}
	

	@Override
	public String toString() {
		StringJoiner stringJoiner = new StringJoiner("\n");
		stringJoiner.add(super.toString());
		// TODO afficher "Je suis une gazeuse" | "Je suis rocheuse");
		return stringJoiner.toString();
	}

	@Override
	public RESULT genererEnvironnement() {		
		try {
			System.out.println("Création de l'environnement de la planète "+getLibelle() + "...");
			UniversUtils.creerEnvironnementPlanete();
		}
		catch (Throwable throwable) {
			throw throwable;
		}
		finally {
			return null;
		}
		
	}


	public boolean isEstGazeuse() {
		return estGazeuse;
	}


	public void setEstGazeuse(boolean estGazeuse) {
		this.estGazeuse = estGazeuse;
	}


	@Override
	public synchronized void run() {

		
		try {
			System.out.println(this.getLibelle() + " dit : Attente notification de l'etoile...");
			synchronized(this) {
				wait();
				System.out.println(this.getLibelle() + " tourne et va créer ses lunes...");
				// TODO creation des lunes
				genererEnvironnement();
			}		
		} catch (InterruptedException e) {}
		
		// TODO la planete tourne tant que son etoile est en vie
		
		
	}

	
	

}
