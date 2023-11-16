package ko.co.sonsystem;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;

import egovframework.com.config.EgovWebApplicationInitializer;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author : s-onsystem
 * @since : 2023. 11. 16.
 * @version : 1.0
 *
 * @package : ko.co.sonsystem
 * @filename : BootApp.java
 * @modificationInformation
 *
 *
 */
@Slf4j
@ServletComponentScan
@SpringBootApplication
@Import({EgovWebApplicationInitializer.class})
public class BootApp {
	public static void main(String[] args) {
		log.debug("##### BootApp Start #####");

		SpringApplication springApplication = new SpringApplication(BootApp.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		//springApplication.setLogStartupInfo(false);
		springApplication.run(args);

		log.debug("##### BootApp End #####");
	}

}
