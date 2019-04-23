package com.artisans.inventory;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import com.artisans.inventory.controller.ViewScope;
import com.google.common.collect.ImmutableMap;

@SpringBootApplication

@EnableAutoConfiguration(exclude = {
	    org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class CostingLiteApplication implements ServletContextAware {
		
	@Autowired
	private Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(CostingLiteApplication.class, args);
	}
	
	@Bean
	public static CustomScopeConfigurer viewScope() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		configurer.setScopes(new ImmutableMap.Builder<String, Object>().put("view", new ViewScope()).build());
		return configurer;
	}

	@Bean
	public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
		ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>(
				new FacesServlet(), "*.xhtml");
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		// Iniciar el contexto de JSF
		// http://stackoverflow.com/a/25509937/1199132		
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        
        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.UPLOADER", "commons");
        //https://github.com/primefaces/primefaces/issues/3457
        servletContext.setInitParameter("primefaces.MOVE_SCRIPTS_TO_BOTTOM", Boolean.TRUE.toString());
        
        if(environment.getActiveProfiles()[0].toString().equalsIgnoreCase("prod")) {
        	servletContext.setInitParameter("primefaces.THEME", "south-street");
        } else {
        	servletContext.setInitParameter("primefaces.THEME", "hot-sneaks");
        }
	}
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
    public FilterRegistrationBean FileUploadFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new org.primefaces.webapp.filter.FileUploadFilter());
        registration.setName("PrimeFaces FileUpload Filter");
        registration.addUrlPatterns("/*");
        registration.setDispatcherTypes(DispatcherType.FORWARD, DispatcherType.REQUEST);
        registration.addServletRegistrationBeans(servletRegistrationBean());
        registration.setOrder(2);
        return registration;
    }

    @SuppressWarnings("rawtypes")
	@Bean
    public FilterRegistrationBean hiddenHttpMethodFilterDisabled(
            @Qualifier("hiddenHttpMethodFilter") HiddenHttpMethodFilter filter) {
        @SuppressWarnings("unchecked")
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }	
}
