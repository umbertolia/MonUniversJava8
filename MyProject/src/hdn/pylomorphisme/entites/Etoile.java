package hdn.pylomorphisme.entites;

import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import hdn.pylomorphisme.abstraction.ObjetStellaire;
import hdn.pylomorphisme.constantes.OBJET_TYPE;
import hdn.pylomorphisme.constantes.RESULT;
import hdn.pylomorphisme.exception.UniversException;
import hdn.pylomorphisme.main.MonUnivers;
import hdn.pylomorphisme.utils.UniversUtils;

public class Etoile extends ObjetStellaire  {

	public final static int NBR_PLANETES_MAX = 9;

	private boolean estEtoilePrincipale;
	
	private int nombreAtomes;
	
	
	public Etoile(OBJET_TYPE objet_TYPE) {
		super(objet_TYPE);
	}

	public Etoile(OBJET_TYPE objet_TYPE, String libelle) {
		super(objet_TYPE, libelle);
		// TODO initialiser le nombre d'atomes : lecture de conf.properties (doit etre situé entre un min et un max : nombre généré aléatoirement par le systeme)
		nombreAtomes = 2;
	}

	@Override
	public String toString() {
		StringJoiner stringJoiner = new StringJoiner("\n");
		stringJoiner.add(super.toString());
		// TODO section à traiter en Java8 avec streams et filtre
		// TODO afficher "Je possède " + nbr + " planetes" | aucune planete)
		//		--> a recuperer depuis l'environnement et selon le type d'objet (planete)
		// TODO afficher "Je ne suis pas un systeme binaire" | "Je suis un systeme binaire"); 
		// 		--> a recuperer depuis l'environnement et selon le type d'objet
		// (etoile)
		return stringJoiner.toString();
	}

	@Override
	public RESULT genererEnvironnement() {
		try {
			System.out.println("Création de l'environnement de l'étoile "+getLibelle() + "...");
			this.setEnvironnement(UniversUtils.creerEnvironnementEtoile());
		} catch (Throwable throwable) {
			// TODO capturer l'exception
			throw new UniversException(throwable.getMessage());
			// System.err.println(throwable.getMessage());
		} finally {
			return null;
		}

	}

	
	
	@Override
	public synchronized void run()  {
		// le thread créer l'environnement de l'etoile et fait vivre l'etoile selon son nombre d'atomes
		
		int temps_attente = 2000 + new Random().nextInt(2000);
		
		
		try {
			genererEnvironnement();
			Thread.sleep(temps_attente);
			System.out.println("environnement de l'étoile "+this.getLibelle() + " crée !\n");
			// TODO on doit faire un submit sur toutes les planetes !
			MonUnivers.executorService.submit(this.getEnvironnement().get(0));
			Thread.sleep(temps_attente);
			synchronized (getEnvironnement().get(0)) {
				// TODO on doit faire un notify sur toutes les planetes !
				this.getEnvironnement().get(0).notify();
            }
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		while (this.nombreAtomes > 0) {
			try {
				Thread.sleep(2000 + new Random().nextInt(2000));
				nombreAtomes--;
				System.out.println(this.getClass().getSimpleName() + " " +this.getLibelle() + " "+ nombreAtomes + " atomes");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		System.out.println(this.getLibelle() + " détruite");
	}

	public int getNombreAtomes() {
		return nombreAtomes;
	}

	public void setNombreAtomes(int nombreAtomes) {
		this.nombreAtomes = nombreAtomes;
	}


}
