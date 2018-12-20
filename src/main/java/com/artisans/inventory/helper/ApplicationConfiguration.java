/**
 * 
 */
package com.artisans.inventory.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author bjacob
 *
 */

@Configuration
@PropertySource("classpath:config.properties")
public class ApplicationConfiguration {

	   @Autowired
	    private Environment env;

	    public String getProperty(String propertyName) {
	        return env.getProperty(propertyName);
	    }
}
