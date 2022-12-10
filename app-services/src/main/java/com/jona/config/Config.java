package com.jona.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {

	protected static Logger LOG = LoggerFactory.getLogger(Config.class);

	private static String CONFIG_FILENAME = "application.properties";

	private static Properties properties = new Properties();

	private static boolean development = false;

	static {
		try {
			load();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	public static void load() throws Exception {

		InputStream propStream = null;

		String paramProperties = System.getProperty(CONFIG_FILENAME);
		String warProperties = "/" + CONFIG_FILENAME;

		if (paramProperties != null) {
			LOG.info("Archivo de propiedades definido en parámetro {} = {}", CONFIG_FILENAME, paramProperties);
			propStream = new FileInputStream(new File(paramProperties));
		} else {
			LOG.info("Archivo de propiedades {} dentro del WAR", Config.class.getResource(warProperties));
			propStream = Config.class.getResourceAsStream(warProperties);
		}

		properties.clear();
		properties.load(propStream);

		String developmentProp = (String) properties.get("development");

		if ("true".equals(developmentProp))
			development = true;
		else
			development = false;

		propStream.close();

	}

	public static String get(String property) {
		return (String) properties.get(property);
	}

	public static boolean isDevelopment() {
		return development;
	}

	public static String getVersion() {
		return properties.getProperty("version");
	}

	public static String getBuildDate() {
		return properties.getProperty("build.date");
	}

	public static String getName() {
		return properties.getProperty("name");
	}

}
