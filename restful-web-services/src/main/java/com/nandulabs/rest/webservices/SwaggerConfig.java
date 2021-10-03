package com.nandulabs.rest.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {

	/*
	 * public static final Contact DEFAULT_CONTACT = new Contact("Narendra Sahu",
	 * "www.nandulabs.com", "nandulabs@gmail.com"); private static final Set<String>
	 * DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(
	 * Arrays.asList("application/json", "application/xml"));
	 * 
	 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
	 * .apiInfo(new
	 * ApiInfoBuilder().contact(DEFAULT_CONTACT).title("Nandulabs Api Documentation"
	 * ) .license("Apache 2.0").licenseUrl(
	 * "http://www.apache.org/licenses/LICENSE-2.0")
	 * .description("Nandulabs Api Documentation").version("1.0").termsOfServiceUrl(
	 * "urn:tos").build()) .produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(
	 * DEFAULT_PRODUCES_AND_CONSUMES); }
	 */

	@Bean
	public LinkDiscoverers discoverers() {
		List<LinkDiscoverer> plugins = new ArrayList<>();
		plugins.add(new CollectionJsonLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
	}
}
