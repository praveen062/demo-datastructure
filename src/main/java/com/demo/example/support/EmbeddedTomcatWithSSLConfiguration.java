package com.demo.example.support;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.catalina.connector.Connector;
import org.apache.commons.io.FileUtils;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class EmbeddedTomcatWithSSLConfiguration {

	
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.addAdditionalTomcatConnectors(createSslConnector());
		return tomcat;
	}

	private Connector createSslConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		try {
			System.out.println("fing me");
			Resource resource = new ClassPathResource("KeyStore.jks");
			System.out.println("Resource path is "+resource.getURI());
			File keystore = getFile(resource);
			File truststore =  getFile(resource);
		    connector.setScheme("https");
            connector.setSecure(true);
            connector.setPort(getHTTPSPort());
            protocol.setSSLEnabled(true);
            protocol.setKeystoreFile(keystore.getAbsolutePath());
            protocol.setKeystorePass(getKeystorePass());
            protocol.setTruststoreFile(truststore.getAbsolutePath());
            protocol.setTruststorePass(getKeystorePass());
            // ? protocol.setKeyAlias("apitester");
            return connector;
		} catch (Exception ex) {
			System.out.println("ERROR PRAVEEN" + ex.getMessage());
			throw new IllegalStateException(
					"can't access keystore: [" + "keystore" + "] or truststore: [" + "keystore" + "]", ex);
		}
	}
	
	 protected int getHTTPSPort() {
	        // TODO This shouldn't be hard-coded here, but configurable
	        return 8549;
	    }

	    protected String getKeystorePass() {
	        return "openmf";
	    }

	public File getFile(Resource resource) throws IOException {
		try {
			return resource.getFile();
		} catch (IOException e) {
			// Uops.. OK, try again (below)
		}

		try {
			URL url = resource.getURL();
			/**
			 * // If this creates filenames that are too long on Win, // then
			 * could just use resource.getFilename(), // even though not unique,
			 * real risk prob. min.bon String tempDir =
			 * System.getProperty("java.io.tmpdir"); tempDir = tempDir + "/" +
			 * getClass().getSimpleName() + "/"; String path = url.getPath();
			 * String uniqName = path.replace("file:/", "").replace('!', '_');
			 * String tempFullPath = tempDir + uniqName;
			 **/
			// instead of File.createTempFile(prefix?, suffix?);
			File targetFile = new File(resource.getFilename());
			long len = resource.contentLength();
			System.out.println("the file location is "+targetFile.getAbsolutePath());
			if (!targetFile.exists() || targetFile.length() != len) { // Only
																		// copy
																		// new
																		// files
				FileUtils.copyURLToFile(url, targetFile);
			}
			return targetFile;
		} catch (IOException e) {
			// Uops.. erm, give up:
			throw new IOException("Cannot obtain a File for Resource: " + resource.toString(), e);
		}
	}
}
