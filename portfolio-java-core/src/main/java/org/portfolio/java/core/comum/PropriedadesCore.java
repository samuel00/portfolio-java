package org.portfolio.java.core.comum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class PropriedadesCore {

    private static final Logger     logger          = LoggerFactory.getLogger(PropriedadesCore.class);
    public static final  String     AMBIENTE        = "configuracao.ambiente";
    public static final  String     VERSAO          = "configuracao.versao";
    public static final  String     NOME_DO_ARQUIVO = "core.properties";
    private static final Properties PROPERTIES;

    private PropriedadesCore() {
    }

    static {
	PROPERTIES = new Properties();
	final InputStream inputStream = Resource.loadResource(NOME_DO_ARQUIVO);
	try {
	    PROPERTIES.load(inputStream);
	} catch (Exception e) {
	    logger.error("Erro ao carregar arquivo de configuracoes iniciais!", e);
	}
    }

    public static String obterPropriedade(String nomeDaPropriedade) {
	return PROPERTIES.getProperty(nomeDaPropriedade);
    }

    public static String getVersao() {
	return obterPropriedade(VERSAO);
    }
}
