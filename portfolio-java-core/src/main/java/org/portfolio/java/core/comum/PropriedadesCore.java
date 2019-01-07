package org.portfolio.java.core.comum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class PropriedadesCore{

    static final Logger      logger          = LoggerFactory.getLogger(PropriedadesCore.class);
    static final String      NOME_DO_ARQUIVO = "core.properties";
    static final InputStream INPUT_STREAM    = Resource.loadResource(NOME_DO_ARQUIVO);
    static final String      AMBIENTE        = "configuracao.ambiente";
    static final String      VERSAO          = "configuracao.versao";
    static final String      PROJETO         = "configuracao.projeto";
    private static Properties properties;

    private PropriedadesCore() { }

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


    public static String obterPropriedade(String nomeDaPropriedade) {
	return properties.getProperty(nomeDaPropriedade);
    }

    public static String getAmbiente() {
	return obterPropriedade(AMBIENTE);
    }

    public static String getVersao() {
	return obterPropriedade(VERSAO);
    }

    public static String getProjeto() {
	return obterPropriedade(PROJETO).toUpperCase();
    }
}
