package hdn.pylomorphisme.conf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class ConfReader {

	String result = "";
	InputStream inputStream;
	
	// simule une base de données
	public final static List<String> nomEtoiles = new ArrayList<String>();
	
	public String getPropValues() throws IOException {

		// TODO : la méthode doit remonter uniquement une  UniversException
		
		try {
			Properties properties = new Properties();
			String confFileName = "conf.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(confFileName);

			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException("fichier '" + confFileName + "' absent du classpath");
			}

			properties.forEach(
				(key, val) -> {
					if (key.toString().contains("nom_etoile")) {
						nomEtoiles.add(val.toString());
					}
				}
			);
			
			return result;
	
		} catch (Exception exception) {
			throw exception;
		} finally {
			inputStream.close();
		}	
	}
}