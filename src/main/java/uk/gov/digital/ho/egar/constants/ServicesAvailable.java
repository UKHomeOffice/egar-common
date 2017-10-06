package uk.gov.digital.ho.egar.constants;

public interface ServicesAvailable {
	public static final String ROOT_PATH_SEPERATOR = "/";
	public static final String ROOT_SERVICE_API = "api";
	public static final String ROOT_SERVICE_AUTH = "auth";
	public static final String ROOT_SERVICE_PERSON = "person";
	public static final String ROOT_SERVICE_GAR = "gar";
	public static final String ROOT_SERVICE_ADMIN = "admin";
	public static final String ROOT_SERVICE_REGISTER = "register";
	
	public static final String ROOT_PATH_AUTH = 
			ROOT_PATH_SEPERATOR + ROOT_SERVICE_API + ROOT_PATH_SEPERATOR + ROOT_SERVICE_AUTH;
	public static final String ROOT_PATH_PERSON = 
			ROOT_PATH_SEPERATOR + ROOT_SERVICE_API + ROOT_PATH_SEPERATOR + ROOT_SERVICE_PERSON;
	public static final String ROOT_PATH_GAR = 
			ROOT_PATH_SEPERATOR + ROOT_SERVICE_API + ROOT_PATH_SEPERATOR+ ROOT_SERVICE_GAR;
	public static final String ROOT_PATH_ADMIN = 
			ROOT_PATH_SEPERATOR + ROOT_SERVICE_API + ROOT_PATH_SEPERATOR+ ROOT_SERVICE_ADMIN;
	public static final String ROOT_PATH_REGISTER = 
			ROOT_PATH_SEPERATOR + ROOT_SERVICE_API + ROOT_PATH_SEPERATOR+ ROOT_SERVICE_REGISTER;
}
