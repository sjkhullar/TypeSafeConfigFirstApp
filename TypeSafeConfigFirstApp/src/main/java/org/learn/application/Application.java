package org.learn.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	private static final Config config = ConfigFactory.load();
	public static void main(String[] args) {
		
		logger.info("Start Reading HOCON file:");

		logger.info("UserName={}",config.getString("userInfo.name"));
		logger.info("age={}",config.getInt("userInfo.age"));
		logger.info("Array of roles={}",config.getStringList("userInfo.roles"));
		
		logger.info("Database userName={}",config.getString("database.user"));
		logger.info("Database password={}",config.getString("database.password"));
		
		//Read environment variable
		if(config.hasPath("java_directory")) {
			logger.info("Java installed directory={}",config.getString("java_directory"));
		}
		
		logger.info("End reading HOCON file");
	}
}
