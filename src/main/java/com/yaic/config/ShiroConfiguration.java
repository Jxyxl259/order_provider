package com.yaic.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.yaic.fa.shiro.credentials.RetryLimitHashedCredentialsMatcher;
import com.yaic.fa.shiro.modules.FormAuthenticationCaptchaFilter;
import com.yaic.fa.shiro.realm.UserRealm;
import com.yaic.fa.shiro.shiro.filter.SysUserFilter;
import com.yaic.fa.spring.CustomDefaultFilterChainManager;
import com.yaic.fa.spring.CustomPathMatchingFilterChainResolver;
import com.yaic.fa.spring.SpringCacheManagerWrapper;


/**
 *
 */
@Configuration
public class ShiroConfiguration
{

	/**
	 * @return the ehcacheManager bean
	 */
	@Bean(name = "ehcacheManager")
	public EhCacheManagerFactoryBean ehcacheManager()
	{
		final EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
		bean.setConfigLocation(new ClassPathResource("config/ehcache/spring-ehcache-config.xml"));
		return bean;
	}

	/**
	 * @return the springCacheManager bean
	 */
	@Bean(name = "springCacheManager")
	public EhCacheCacheManager springCacheManager()
	{
		final EhCacheCacheManager bean = new EhCacheCacheManager();
		bean.setCacheManager(ehcacheManager().getObject());
		return bean;
	}

	/**
	 * 缓存管理器
	 *
	 * @param springCacheManager
	 * @return the cacheManager bean
	 */
	@Bean(name = "cacheManager")
	public SpringCacheManagerWrapper cacheManager(final EhCacheCacheManager springCacheManager)
	{
		final SpringCacheManagerWrapper bean = new SpringCacheManagerWrapper();
		bean.setCacheManager(springCacheManager);
		return bean;
	}

	/**
	 * 凭证匹配器
	 *
	 * @param cacheManager
	 * @return the credentialsMatcher bean
	 */
	@Bean(name = "credentialsMatcher")
	public RetryLimitHashedCredentialsMatcher credentialsMatcher(final SpringCacheManagerWrapper cacheManager)
	{
		final RetryLimitHashedCredentialsMatcher bean = new RetryLimitHashedCredentialsMatcher(cacheManager);
		bean.setHashAlgorithmName("SHA1");
		bean.setHashIterations(2);
		bean.setStoredCredentialsHexEncoded(true);
		return bean;
	}

	/**
	 * 将自己的验证方式加入容器
	 *
	 * @param credentialsMatcher
	 * @return the userRealm bean
	 */
	@Bean(name = "userRealm")
	public UserRealm userRealm(final RetryLimitHashedCredentialsMatcher credentialsMatcher)
	{
		final UserRealm myShiroRealm = new UserRealm();
		myShiroRealm.setCredentialsMatcher(credentialsMatcher);
		myShiroRealm.setCachingEnabled(false);
		return myShiroRealm;
	}

	/**
	 * 将自己的验证方式加入容器
	 *
	 * @return the sessionIdGenerator bean
	 */
	@Bean(name = "sessionIdGenerator")
	public JavaUuidSessionIdGenerator sessionIdGenerator()
	{
		return new JavaUuidSessionIdGenerator();
	}

	/**
	 * 会话Cookie模板
	 *
	 * @return the sessionIdCookie bean
	 */
	@Bean(name = "sessionIdCookie")
	public SimpleCookie sessionIdCookie()
	{
		final SimpleCookie bean = new SimpleCookie("sid");
		bean.setHttpOnly(true);
		bean.setMaxAge(-1);
		return bean;
	}

	/**
	 * 会话Cookie模板
	 *
	 * @return the rememberMeCookie bean
	 */
	@Bean(name = "rememberMeCookie")
	public SimpleCookie rememberMeCookie()
	{
		final SimpleCookie bean = new SimpleCookie("rememberMe");
		bean.setHttpOnly(true);
		bean.setMaxAge(2592000);
		return bean;
	}

	/**
	 * 会话Cookie模板
	 *
	 * @param rememberMeCookie
	 * @return the rememberMeManager bean
	 */
	@Bean(name = "rememberMeManager")
	public CookieRememberMeManager rememberMeManager(final SimpleCookie rememberMeCookie)
	{
		final CookieRememberMeManager bean = new CookieRememberMeManager();
		bean.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
		bean.setCookie(rememberMeCookie);
		return bean;
	}

	/**
	 * 会话DAO
	 *
	 * @param sessionIdGenerator
	 * @return the sessionDAO bean
	 */
	@Bean(name = "sessionDAO")
	public EnterpriseCacheSessionDAO sessionDAO(final JavaUuidSessionIdGenerator sessionIdGenerator)
	{
		final EnterpriseCacheSessionDAO bean = new EnterpriseCacheSessionDAO();
		bean.setActiveSessionsCacheName("shiro-activeSessionCache");
		bean.setSessionIdGenerator(sessionIdGenerator);
		return bean;
	}

	/**
	 * 会话管理器
	 *
	 * @param sessionDAO
	 * @param sessionIdCookie
	 * @return the sessionManager bean
	 */
	@Bean(name = "sessionManager")
	public DefaultWebSessionManager sessionManager(final EnterpriseCacheSessionDAO sessionDAO, final SimpleCookie sessionIdCookie)
	{
		final DefaultWebSessionManager bean = new DefaultWebSessionManager();
		bean.setGlobalSessionTimeout(1800000);
		bean.setSessionValidationSchedulerEnabled(true);
		bean.setSessionDAO(sessionDAO);
		bean.setSessionIdCookieEnabled(true);
		bean.setSessionIdCookie(sessionIdCookie);
		return bean;
	}

	/**
	 * 安全管理器
	 *
	 * @param userRealm
	 * @param sessionManager
	 * @param cacheManager
	 * @param rememberMeManager
	 * @return the securityManager bean
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager(final UserRealm userRealm, final DefaultWebSessionManager sessionManager,
			final SpringCacheManagerWrapper cacheManager, final CookieRememberMeManager rememberMeManager)
	{
		final DefaultWebSecurityManager bean = new DefaultWebSecurityManager();
		bean.setRealm(userRealm);
		bean.setSessionManager(sessionManager);
		bean.setCacheManager(cacheManager);
		bean.setRememberMeManager(rememberMeManager);
		return bean;
	}

	/**
	 * 相当于调用SecurityUtils.setSecurityManager(securityManager)
	 *
	 * @param securityManager
	 * @return null
	 */
	@Bean
	public String methodInvokingFactoryBean(final DefaultWebSecurityManager securityManager)
	{
		SecurityUtils.setSecurityManager(securityManager);
		return null;
	}

	/**
	 * 基于Form表单的身份验证过滤器
	 *
	 * @return the myCaptchaFilter bean
	 */
	@Bean(name = "myCaptchaFilter")
	public FormAuthenticationCaptchaFilter myCaptchaFilter()
	{
		final FormAuthenticationCaptchaFilter bean = new FormAuthenticationCaptchaFilter();
		return bean;
	}

	/**
	 * 安全管理器
	 *
	 * @return the sysUserFilter bean
	 */
	@Bean(name = "sysUserFilter")
	public SysUserFilter sysUserFilter()
	{
		final SysUserFilter bean = new SysUserFilter();
		return bean;
	}

	/**
	 * @param myCaptchaFilter
	 * @param sysUserFilter
	 * @return the filterChainManager bean
	 */
	@Bean(name = "filterChainManager")
	public CustomDefaultFilterChainManager filterChainManager(final FormAuthenticationCaptchaFilter myCaptchaFilter,
			final SysUserFilter sysUserFilter)
	{
		final CustomDefaultFilterChainManager bean = new CustomDefaultFilterChainManager();
		//配置登录的url和登录成功的url
		bean.setLoginUrl("/login");
		bean.setSuccessUrl("/");
		bean.setUnauthorizedUrl("/unauthorized.jsp");
		final Map<String, Filter> customFilters = new HashMap<String, Filter>();
		customFilters.put("authc", myCaptchaFilter);
		customFilters.put("sysUser", sysUserFilter);
		bean.setCustomFilters(customFilters);
		//配置访问权限
		final LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/", "authc");
		filterChainDefinitionMap.put("/index", "authc");
		filterChainDefinitionMap.put("/login*", "authc");
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/unauthorized.jsp*", "authc");
		filterChainDefinitionMap.put("/user/**", "authc");
		filterChainDefinitionMap.put("/userRole/**", "authc");
		filterChainDefinitionMap.put("/role/**", "authc");
		filterChainDefinitionMap.put("/resource/**", "authc");
		filterChainDefinitionMap.put("/parameterType/**", "authc");
		filterChainDefinitionMap.put("/parameter/**", "authc");
		filterChainDefinitionMap.put("/company/**", "authc");
		filterChainDefinitionMap.put("/config/**", "authc");
		filterChainDefinitionMap.put("/mapping/**", "authc");
		filterChainDefinitionMap.put("/synPolicyCfg/**", "authc");
		filterChainDefinitionMap.put("/synPolicy/**", "authc");
		filterChainDefinitionMap.put("/synPolicySurrender/**", "authc");
		filterChainDefinitionMap.put("/shopOrderInfo/**", "authc");

		bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return bean;

	}

	/**
	 * 安全管理器
	 *
	 * @param filterChainManager
	 * @return the filterChainResolver bean
	 */
	@Bean(name = "filterChainResolver")
	public CustomPathMatchingFilterChainResolver filterChainResolver(final CustomDefaultFilterChainManager filterChainManager)
	{
		final CustomPathMatchingFilterChainResolver bean = new CustomPathMatchingFilterChainResolver();
		bean.setCustomDefaultFilterChainManager(filterChainManager);
		return bean;
	}

	/**
	 * Shiro的Web过滤器
	 *
	 * @param securityManager
	 * @return the shiroFilter bean
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(final DefaultWebSecurityManager securityManager)
	{
		final ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		return bean;
	}

	/**
	 * Shiro生命周期处理器
	 *
	 * @return the lifecycleBeanPostProcessor bean
	 */
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor()
	{
		final LifecycleBeanPostProcessor bean = new LifecycleBeanPostProcessor();
		return bean;
	}


}
