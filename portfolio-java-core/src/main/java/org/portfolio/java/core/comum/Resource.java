package org.portfolio.java.core.comum;

import java.io.InputStream;

public class Resource {

    private Resource(){}

    public static InputStream loadResource(String resource){
	return Resource.class.getClassLoader().getResourceAsStream(resource);
    }

}
