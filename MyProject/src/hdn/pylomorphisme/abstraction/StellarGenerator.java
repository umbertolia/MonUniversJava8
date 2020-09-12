package hdn.pylomorphisme.abstraction;

import java.util.function.Consumer;

@FunctionalInterface
public interface StellarGenerator<T> {
	
	Consumer<T> creerEnvironnement();

}
