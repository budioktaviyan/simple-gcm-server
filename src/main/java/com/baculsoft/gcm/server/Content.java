package com.baculsoft.gcm.server;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Content implements Serializable {
	private static final long serialVersionUID = 9043924401325495825L;

	@JsonProperty("registration_ids")
	private List<String> registrationIds;

	@JsonProperty("data")
	private Map<String, String> contents;

	public void addRegistrationId(String registrationId) {
		if (registrationIds == null) {
			registrationIds = new LinkedList<String>();
		}

		registrationIds.add(registrationId);
	}

	public void createContent(String title, String message) {
		if (contents == null) {
			contents = new HashMap<String, String>();
		}

		contents.put("title", title);
		contents.put("message", message);
	}
}