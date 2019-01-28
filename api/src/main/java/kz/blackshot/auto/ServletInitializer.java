package kz.blackshot.auto;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(ApiApplication.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException{
        super.onStartup(servletContext);
//        servletContext.getSessionCookieConfig().setName("API-Token");
//        servletContext.getSessionCookieConfig().setSecure(false);
//        servletContext.getSessionCookieConfig().setHttpOnly(false);

    }

}
