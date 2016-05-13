package com.baculsoft.gcm.server;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Content implements Serializable {
	private static final long serialVersionUID = -548215338125422131L;

	private List<String> registration_ids;
	private Map<String, String> data;

	public void addRegId(String regId) {
		if (registration_ids == null) {
			registration_ids = new LinkedList<String>();
		}

		registration_ids.add(regId);
	}

	public void createData(String notificationKey, String message) {
		if (data == null) {
			data = new HashMap<String, String>();
		}

		data.put("notificationKey", notificationKey);
		data.put("message", message);
	}
}