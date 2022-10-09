package webservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("rest")
public class RestActivator extends Application {
	public RestActivator() {

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("esprit.sae.project/rest");
		beanConfig.setResourcePackage("webservice");
		beanConfig.setPrettyPrint(true);
		beanConfig.setScan(true);
		beanConfig.setSchemes(new String[]{"http"});
		}
	@Override
	public Set<Class<?>> getClasses() {
	Set<Class<?>> resources = new HashSet();

	resources.add(EmployeeWS.class);
	resources.add(EmployeeWS.class);

	resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
	resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
	return resources;	
}
}
