package uk.gov.digital.ho.egar.constants;

public interface SwaggerConstants {
	/**
     * The Web path for: the api root.
     */
    String PATH_DATA = "/api";
	/**
     * Part of the sites look and feel comes from webjars.
     * @see <a href=
     *      "https://spring.io/blog/2014/01/03/utilizing-webjars-in-spring-boot">
     *      Utilising WebJars in Spring Boot.</a>
     */
	String PATH_RESOURCES = "/webjars";
	/**
     * Allows the server to find pages under {@link #PATH_RESOURCES}.
     */
	String PATH_RESOURCES_REGEX = PATH_RESOURCES + "/**";
	
	String PATH_RESOURCES_META_INF = "classpath:/META-INF/resources/webjars/";
}
