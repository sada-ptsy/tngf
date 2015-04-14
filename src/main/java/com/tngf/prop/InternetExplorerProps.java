package com.tngf.prop;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class InternetExplorerProps {
	private static final String BUNDLE_NAME = "repository.IEDriver"; 

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private InternetExplorerProps() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
