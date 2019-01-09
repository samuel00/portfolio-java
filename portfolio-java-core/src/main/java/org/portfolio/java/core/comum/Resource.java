package org.portfolio.java.core.comum;

import java.io.InputStream;

public class Resource {

    public static final ClassLoader CLASS_LOADER = Resource.class.getClassLoader();

    private Resource(){}

    public static InputStream loadResource(String resource){
	return CLASS_LOADER.getResourceAsStream(resource);
    }

}
