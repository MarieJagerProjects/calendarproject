package htw.calenderproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//statische Zuordnung aus Endpunkt und ViewName
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(Endpoints.INDEX).setViewName(ViewNames.INDEX);
        registry.addViewController(Endpoints.LOGIN).setViewName(ViewNames.LOGIN);
        registry.addViewController(Endpoints.CALENDER).setViewName(ViewNames.CALENDER);
    }
}
