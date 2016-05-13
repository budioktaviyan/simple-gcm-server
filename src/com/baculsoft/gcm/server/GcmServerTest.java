package com.baculsoft.gcm.server;

public class GcmServerTest {
	public static final String API_KEY = "AIzaSyAlnNgG_JVpdjbEserQhTQ4HtfQFE1ZBew";
	public static final String REG_TOKEN_1 = "fXbtwvlWFsA:APA91bHMoAbOvwdSSaFLjR9dQQ-JZTR1gNYmlzCEvCsFWkia8bX5vDCu7kK8vnFiBjIvNt2caZNvT1IuahEN-X9JmOwsulMBUKS-aGezZ9v8V0KLmqyPJsxv4t8k2izm1wj3DXmlY-cw";
	public static final String REG_TOKEN_2 = "eWzAlDhDpqg:APA91bGeS2YRTYAUavqagAROldHV3nDo8Cndaj4tUEJ7nVP_0JrfWLi6ePoKwt50vhDWsZpJVhA7veKqhIpGyEjtFX6otM72Ascz9jPCuDzYtvu3ECdrZYPBVffsYJTzv-xJmQECAnXo";
	
	public static void main(String[] args) {
		System.out.println("Sending POST to GCM");
		Content content = createContent();
		GcmServices.post(API_KEY, content);
	}

	public static Content createContent() {
		Content content = new Content();
		content.addRegId(REG_TOKEN_1);
		content.addRegId(REG_TOKEN_2);
		content.createData("123456789", "Ini test message dari GCM loh!");

		return content;
	}
}