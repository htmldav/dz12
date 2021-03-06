package com.shephertz.app42.paas.sample.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class Util {

	// public final void whenConvertingInputStreamToFile_thenCorrect4() throws IOException {
    //     final InputStream initialStream = FileUtils.openInputStream(new File("src/test/resources/sample.txt"));

    //     final File targetFile = new File("src/test/resources/targetFile.tmp");

    //     FileUtils.copyInputStreamToFile(initialStream, targetFile);
    // }

	static Properties dbProps = new Properties();
	static File dbFile = null;
	static {
		try {
			final InputStream initialStream = FileUtils.openInputStream(new File("ROOT/Config.properties"));
			final File dbFile = new File("targetFile.tmp");
			FileUtils.copyInputStreamToFile(initialStream, dbFile);
			
			// InputStream inputStream = InputStream.class.getResourceAsStream("/ROOT/Config.properties");
			// dbFile = new File(new InputStreamReader(inputStream));

			// FileUtils.copyInputStreamToFile(inputStream, dbFile);

			// Files.copy(inputStream, dbFile, StandardCopyOption.REPLACE_EXISTING);

			// dbProps.load(new InputStreamReader(inputStream));

			dbProps.load(new FileInputStream(dbFile.getAbsolutePath()));

			// --------------------------------------------
			// dbFile = new File("ROOT/Config.properties");
			// dbProps.load(new FileInputStream(dbFile.getAbsolutePath()));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * This function fetches the DB Ip from Config.properties
	 */
	public static String getDBIp() {
		return dbProps.getProperty("app42.paas.db.ip");
	}

	/*
	 * This function fetches the DBPassword from Config.properties
	 */
	public static String getDBPassword() {
		return dbProps.getProperty("app42.paas.db.password");
	}

	/*
	 * This function fetches Username from Config.properties
	 */
	public static String getDBUser() {
		return dbProps.getProperty("app42.paas.db.username");
	}
	
	/*
	 * This function fetches the DB Name from Config.properties
	 */
	public static String getDBName() {
		return dbProps.getProperty("app42.paas.db.name");
	}

	/*
	 * This function fetches the DB Port from Config.properties
	 */
	public static int getDBPort() {
		return new Integer(dbProps.getProperty("app42.paas.db.port"));
	}
	

}
