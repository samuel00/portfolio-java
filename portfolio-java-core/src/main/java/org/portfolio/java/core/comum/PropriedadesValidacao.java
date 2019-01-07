package org.portfolio.java.core.comum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class PropriedadesValidacao {

    private static Properties properties;
    static final Logger logger = LoggerFactory.getLogger(PropriedadesCore.class);
    public static final String SEM_TAXA          = "info.sem.taxa";
    public static final String SEM_AGENDAMENTO   = "info.sem.agendamento";

    static {
        properties = new Properties();
	final String      nomeDoArquivo = "ValidationMessages.properties";
	final InputStream inputStream    = Resource.loadResource(nomeDoArquivo);
	try {
	    properties.load(inputStream);
	} catch (Exception e) {
	    logger.error("Erro ao carregar arquivo de configuracoes iniciais!", e);
	}
    }

    private PropriedadesValidacao(){}

    public static String getMensagen(String chaveMensagem) {
	return properties.getProperty(chaveMensagem);
    }


}
