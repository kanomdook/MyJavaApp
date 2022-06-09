package com.dookdev.init;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.X509Certificate;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.MacProvider;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.Keys;


public class Example5 {
	
	private static String SECRET_KEY = "oeRaYY7Wo24sDqKSX3IM9ASGmdGPmkTd9jo1QTy4b7P9Ze5_9hKolVX8xNrQDcNRfVEdTZNOuOyqEGhXEbdJI-ZQ19k_o9MI0y3eZN2lp9jow55FfXMiINEdt1XR85VipRLSOkT6kSpzs2x-jbLDiz9iFVzkd81YKxMgPA7VfZeQUm4n-mOmnWMaVX30zGFU4L3oPBctYKkl4dYfqYWqRNfrgPJVi5DGFjywgxx0ASEiJHtV72paI3fDR2XwlSkyhhmY-ICjCRmsJN4fX1pdoL8a18-aQrvyu4j0Os6dVPYIoPvvY0SAZtWYKHfM15g7A3HD4cVREf9cUsprCRK93w";


	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
//		Hashtable<String, String> varString = new Hashtable<String, String>();
//		varString.put("Id", "1234");
//		varString.put("Path", "/www/app/");
//		varString.put("Instance", "xxxxx");
//		varString.put("Port", "22");
//		getAlarmHour("GETALARMHOUR \"{Hr}\"", "1596085929251", varString);
//		System.out.println(varString);

//		final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//		String secretString = Encoders.BASE64.encode(SECRET_KEY.getEncoded());
//		System.out.println(secretString);
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String secretString = Encoders.BASE64.encode(key.getEncoded());
		System.out.println(secretString);

//		System.out.println(createJWT("dd","is","sub", 12345));
//		tt();
//		HashMap<String, String> result = verifyToken(
//				"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Inl0ZXN0MDA0IiwiY2FOdW1iZXIiOiI4MDAwMDAxNDQ1IiwibW9kdWxlIjoiRUNVU1RQT1JUQUwiLCJpYXQiOjE2MDAxNDAxMDEsImV4cCI6MTYwMDE2ODkwMX0.aZJYkBH1INaggamtbftFqWHZ-5yTqfnKtD_ppO82BTboBcnhdCKmmIfJj5N-NVzoqmIoq2c4C6ORshIz8Sz2Jw");
//		System.out.println(result.get("success"));
//		curlTest();
		
//		long millis = Long.parseLong("-61965648000000");
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeInMillis(millis);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY HH:MM:ss");
//		sdf.setTimeZone(TimeZone.getTimeZone("GMT+7")); 
//		String alarmTime = sdf.format(calendar.getTime());
//		System.out.println(alarmTime);
		

		
//		String string = "2021-03-31 18:22:27";
//		DateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:MM:ss");
//		Date date = format.parse(string);
//		System.out.println(date);
//		
//		String pattern = "dd/MM/YYYY HH:MM:ss";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		String dateStr = simpleDateFormat.format(date);
//		System.out.println(dateStr);
		
//		SimpleDateFormat sdfx = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateString = "2020-06-03 18:14:43.0";
//		Date date = sdfx.parse(dateString);
//		System.out.println("Time : "+date.toString());
//		System.out.println("Time in milliseconds : "+(date.getTime()/1000));
	}
	
	public static void curlTest() {
		String command = "curl -H \"Accept: application/json\" -H \"Content-type: application/json\" -X POST -d '{\"token\": \"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Inl0ZXN0MDA0IiwiY2FOdW1iZXIiOiI4MDAwMDAxNDQ1IiwibW9kdWxlIjoiRUNVU1RQT1JUQUwiLCJpYXQiOjE2MDAxNDAxMDEsImV4cCI6MTYwMDE2ODkwMX0.aZJYkBH1INaggamtbftFqWHZ-5yTqfnKtD_ppO82BTboBcnhdCKmmIfJj5N-NVzoqmIoq2c4C6ORshIz8Sz2Jw\"}' -k https://10.138.39.214:8080/api/verifyToken";
		Process process;
		try {
			process = Runtime.getRuntime().exec(command);
			InputStreamReader ir = new InputStreamReader(process.getInputStream());
	        BufferedReader br = new BufferedReader(ir);
	        String message = br.readLine();
	        System.out.println(message);   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String createJWT(String id, String issuer, String subject, long ttlMillis) {
		  
	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);

	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	    
	    Serializer<Map<String, ?>> serializer = null;

	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder()
	    		.serializeToJsonWith(serializer)
	            .setSubject("Bob")
	            .signWith(signingKey);
	  
	    //if it has been specified, let's add the expiration
	    if (ttlMillis > 0) {
	        long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }  
	  
	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}
	
	public static void tt() {
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

		String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();
		
		System.out.println(jws);
	}
	
	public static Claims decodeJWT(String token) {
		Jws<Claims> jwsClaims = Jwts.parserBuilder()
                .setSigningKey("eCustPortal=")
                .build()
                .parseClaimsJws(token);
		String userName = jwsClaims.getBody()
                .get("userName", String.class);
		System.out.println(userName);
		
		return null;
	}
	
	public static void getAlarmHour(String cmd, String alarmTime, Hashtable<String, String> varString) {
		final Pattern pattern = Pattern.compile("\\{[a-zA-Z0-9]*\\}");
		Matcher matcher = pattern.matcher(cmd);
		while (matcher.find()) {
			String _valiable = StringUtils.substringBetween(matcher.group(), "{", "}");
//			System.out.println(_valiable);
			long millis = Long.parseLong(alarmTime);
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(millis);
			String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
			varString.put(_valiable, hour);
			break;
		}
	}
	
	public static HashMap<String, String> verifyToken(String token) {
		disableSslVerification();
		HashMap<String, String> result = new HashMap<String, String>();
//		System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\ASUS\\Desktop\\job\\eCustPortalProject\\eCustPortalApp\\security\\cert.key");
//		System.setProperty("javax.net.ssl.trustStorePassword","1234");
//		System.setProperty("javax.net.ssl.keyStore","C:\\Users\\ASUS\\Desktop\\job\\eCustPortalProject\\eCustPortalApp\\security\\cert.key");
//	    System.setProperty("javax.net.ssl.keyStorePassword","1234");
		try {
			String url = "https://10.138.39.214:8080/api/verifyToken";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestMethod("POST");

			JsonObject credencial = new JsonObject();
			credencial.addProperty("token", token);
			OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
			osw.write(credencial.toString());
			osw.close();
			int responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = in.readLine()) != null) {
				response.append(line);
			}
			in.close();
			if (responseCode == 200) {
				JsonObject jsonObject = new JsonParser().parse(response.toString()).getAsJsonObject();
				System.out.println(jsonObject);
				if (jsonObject.has("data")) {
					JsonObject dataObj = jsonObject.get("data").getAsJsonObject();
					if (jsonObject.get("success").getAsBoolean()) {
						result.put("success", "true");
						if (dataObj.has("userName")) {
							result.put("userName", dataObj.get("userName").getAsString());
						}
						if (dataObj.has("caNumber")) {
							result.put("caNumber", dataObj.get("caNumber").getAsString());
						}
						if (dataObj.has("module")) {
							result.put("module", dataObj.get("module").getAsString());
						}
					}
				} else {
					result.put("success", "false");
					result.put("error", jsonObject.get("error").getAsJsonObject().get("message").getAsString());
				}
			} else {
				result.put("success", "false");
				result.put("error", "error code: " + responseCode);
			}
		} catch (Exception e) {
			result.put("success", "false");
			result.put("error", e.toString());
			System.out.println(e);
		}
		return result;
	}
	
	private static void disableSslVerification() {
	    try
	    {
	        // Create a trust manager that does not validate certificate chains
	        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
	            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }
				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
						throws CertificateException {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
						throws CertificateException {
					// TODO Auto-generated method stub
					
				}
	        }
	        };

	        // Install the all-trusting trust manager
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	        // Create all-trusting host name verifier
	        HostnameVerifier allHostsValid = new HostnameVerifier() {
				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					// TODO Auto-generated method stub
					return true;
				}
	        };

	        // Install the all-trusting host verifier
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (KeyManagementException e) {
	        e.printStackTrace();
	    }
	}

}
