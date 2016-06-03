package com.baculsoft.gcm.server;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class GcmServerTest {
	// Change with your own device token
	private static final String REG_TOKEN = "e3yByu5yuoA:APA91bGNi0jsyUAGe_Hh05McV-UKiKUQKoCOW-klrvlUyV2gkNwF6EgRemmIjtR58tHjNV4YhV1uBUriIUqCqc1yszd3S2SzlMTNG4HctEHSLMHmeXEMNtaulNm77lK3eaV7wPPxcZ7Z";

	public static void main(String[] args) {
		System.out.println("Sending POST to GCM...");
		Content content = createContent();
		GcmServices.post(IConstants.API_KEY, content);
	}

	public static Content createContent() {
		Content content = new Content();
		content.addRegistrationId(REG_TOKEN);
		content.createContent("New Message", "Halo Google Cloud Messaging!");

		return content;
	}
}