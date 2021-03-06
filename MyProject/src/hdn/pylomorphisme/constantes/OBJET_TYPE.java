package hdn.pylomorphisme.constantes;

public enum OBJET_TYPE {

	GEANTE_ROUGE(TYPES.ETOILE, COULEUR.ROUGE), NAINE_JAUNE(TYPES.ETOILE, COULEUR.JAUNE),
	SUPERNOAVA(TYPES.ETOILE, COULEUR.MULTIPLES), ETOILE_A_NEUTRONS(TYPES.ETOILE, COULEUR.NOIR),
	PLANETE(TYPES.CORPS_ROCHEUX, COULEUR.MULTIPLES), LUNE(TYPES.CORPS_ROCHEUX, COULEUR.MULTIPLES),
	COMETE(TYPES.CORPS_ROCHEUX, COULEUR.BLANC);

	
	private OBJET_TYPE(TYPES type, COULEUR couleur) {
		this.couleur = couleur;
		this.type = type;
	}

	enum TYPES {
		NEBULEUSE, ETOILE, CORPS_ROCHEUX
	}

	enum COULEUR {
		JAUNE, ROUGE, BLEU, VERT, MULTIPLES, BLANC, GRIS, NOIR
	}

	public TYPES getType() {
		return type;
	}
	
	

}
