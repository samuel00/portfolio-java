package org.portfolio.java.core.comum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class PropriedadesCore {

    private static final Logger     logger   = LoggerFactory.getLogger(PropriedadesCore.class);
    public static final  String     AMBIENTE = "configuracao.ambiente";
    public static final  String     VERSAO   = "configuracao.versao";
    private static       Properties properties;

    private PropriedadesCore() {
    }

    static {
	properties = new Properties();
	final String nomeDoArquivo = "core.properties";
	final InputStream inputStream = Resource.loadResource(nomeDoArquivo);
	try {
	    properties.load(inputStream);
	} catch (Exception e) {
	    logger.error("Erro ao carregar arquivo de configuracoes iniciais!", e);
	}
    }

    public static String obterPropriedade(String nomeDaPropriedade) {
	return properties.getProperty(nomeDaPropriedade);
    }

    public static String getVersao() {
	return obterPropriedade(VERSAO);
    }
}
