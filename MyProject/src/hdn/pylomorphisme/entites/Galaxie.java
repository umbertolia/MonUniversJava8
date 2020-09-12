package hdn.pylomorphisme.entites;

import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

import hdn.pylomorphisme.abstraction.ObjetStellaire;
import hdn.pylomorphisme.conf.ConfReader;
import hdn.pylomorphisme.constantes.OBJET_TYPE;

/**
 * la classe appelle IFactory pour créer les etoiles
 *
 */
public final class Galaxie implements Callable<Stream<ObjetStellaire>> {

	private String id;
	
	public Galaxie(String id) {
		this.id = id;
	}

	@Override
	public Stream<ObjetStellaire> call()  {
		int temps_attente = 1500 + new Random().nextInt(3000);
		try {
			System.out.println("Création de " + this + "...");
			Thread.sleep(temps_attente);				
			// TODO : appel de la IFactory (via UniversUtils) pour créer une liste d'étoiles
			ObjetStellaire etoile1 = new Etoile(OBJET_TYPE.GEANTE_ROUGE, ConfReader.nomEtoiles.get(0));
			//ObjetStellaire etoile2 = new Etoile(OBJET_TYPE.GEANTE_ROUGE, ConfReader.nomEtoiles.get(1));
			//ObjetStellaire etoile3 = new Etoile(OBJET_TYPE.GEANTE_ROUGE, ConfReader.nomEtoiles.get(2));		
			System.out.println(this + " créée après " + (temps_attente) + "ms...\n");
			
			// TODO afficher le nom des etoiles avec un tri alphabetique sur leur libelle (sort, comparable, java8...)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			return Stream.of(new Etoile(OBJET_TYPE.GEANTE_ROUGE, ConfReader.nomEtoiles.get(0)));
		}
	}

	@Override
	public String toString() {
		StringJoiner stringJoiner = new StringJoiner("\n");
		stringJoiner.add(this.getClass().getSimpleName() + " " + id);
		return stringJoiner.toString();
		
	}
	
	

}
