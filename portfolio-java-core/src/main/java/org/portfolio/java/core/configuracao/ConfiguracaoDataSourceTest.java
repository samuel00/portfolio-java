package org.portfolio.java.core.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.Properties;

public class ConfiguracaoDataSourceTest extends ConfiguracaoDataSource{

    @Bean @Override @Profile("test") public DataSource dataSource() {
	EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	return builder.setType(EmbeddedDatabaseType.DERBY).setName("transferencia_eletronica").build();
    }

    @Override public Properties additionalProperties() {
	Properties properties = new Properties();
	properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect");
	properties.setProperty("hibernate.show_sql", "true");
	properties.setProperty("hibernate.hbm2ddl.import_files", "import.sql");
	return properties;
    }

}