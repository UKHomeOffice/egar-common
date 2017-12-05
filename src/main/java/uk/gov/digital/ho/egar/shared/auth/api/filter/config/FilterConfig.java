package uk.gov.digital.ho.egar.shared.auth.api.filter.config;

import java.util.List;

import org.springframework.util.Assert;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class FilterConfig {
	List<RequestMatcher> filterPaths = null;
	
	public void addPaths(List<RequestMatcher> pathRegexs) {
		filterPaths = pathRegexs;
	}
	
	public OrRequestMatcher getOrRequestMatcher() {
		Assert.notNull(filterPaths, "Regex for paths cannot be empty");
		return new OrRequestMatcher(filterPaths);
	}
	
	public AndRequestMatcher getAndRequestMatcher() {
		Assert.notNull(filterPaths, "Regex for paths cannot be empty");
		return new AndRequestMatcher(filterPaths);
	}
}
