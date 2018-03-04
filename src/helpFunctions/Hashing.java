package helpFunctions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class Hashing {
	public static String hash(String text){
		String result="";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-128");
			md.update(text.getBytes());
			result = (new HexBinaryAdapter()).marshal(md.digest()); // Convert to hex.
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
	}
}
