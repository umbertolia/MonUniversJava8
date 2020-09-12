package hdn.pylomorphisme.factory;

import java.util.stream.Stream;

public interface IFactory<T, V> {
	
	// retourne un objet T en fonction d'un autre
	T creerObjet(final V v) throws Throwable;
	
	// retourne une liste objet T rattaché à un autre objet de meme type
	Stream<T> creerListeObjets(int nombre, final T t) throws Throwable;

}
