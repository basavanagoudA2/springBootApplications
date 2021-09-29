package com.js.boot.initilizer;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

public class YmlConfigApplicationContextInitilizer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		//yamlPropertySourceloader just read yml file and convert into propertySource object it wont load into evn obj,and if have multiple documents inside yml it return list<propertySource> obj
		YamlPropertySourceLoader propertySourceLoader=null;
		// get the enviroment object from ioc and load propertysource obj
		ConfigurableEnvironment configurableEnvironment=null;		
		List<PropertySource<?>> propertySources=null;
		//YmalPropertySourceLoader meant for just convert the yml to source object
		propertySourceLoader=new YamlPropertySourceLoader();
		try {
			propertySources=propertySourceLoader.load("config", applicationContext.getResource("classpath:app-global-ymlConfig.yml"));
			System.out.println("config");
			for (PropertySource<?> propertySource : propertySources) {
				configurableEnvironment=applicationContext.getEnvironment();
				configurableEnvironment.getPropertySources().addLast(propertySource);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
