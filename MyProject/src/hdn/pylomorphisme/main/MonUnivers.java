package hdn.pylomorphisme.main;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import hdn.pylomorphisme.abstraction.ObjetStellaire;
import hdn.pylomorphisme.conf.ConfReader;
import hdn.pylomorphisme.entites.Galaxie;
import hdn.pylomorphisme.exception.UniversException;

public class MonUnivers {

	public final static ThreadPoolExecutor executorService;
	
	// TODO proposer un singleton pour l'instance
	static {
		executorService = new ThreadPoolExecutor(2, 2, 1000,
		        TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
	}
	
	public static void main(String[] args) throws UniversException {

		// lecture de la conf	
		try {
			ConfReader confReader = new ConfReader();
			confReader.getPropValues();
		} catch (IOException ioException) {
			System.err.println(ioException.getMessage());
		}
		
		// a partir d'ici, la lecture de la conf est prete.
		// le catalogue de noms d'etoiles est dans ConfReader.nomEtoiles pour simuler la lecture d'une DB
		
		
		// creation de la galaxie
		Future<Stream<ObjetStellaire>> instanceEtoiles = executorService.submit(new Galaxie("Voie Lactée"));
		
		try {
			instanceEtoiles.get().forEach( etoile -> executorService.execute(etoile) );
		} catch (InterruptedException | ExecutionException e) {	}

		while(executorService.getActiveCount() > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {	}
		}
		executorService.shutdown();
		
		if (executorService.isShutdown()) {
			System.out.println("galaxie sans etoiles - fin du prog");
		}
		
		
		// TODO pour une V2
			// 	proposer des interfaces de tri croissants et decroissants sur le nombre de planetes de cahque etoile 
			
		
	
	}

}
