import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("nninja@codingdojo.com", "Nancy Ninja");
        userMap.put("ssamurai@codingdojo.com", "Sam Samurai");
        userMap.put("wwizard@codingdojo.com", "Walter Wizard");
		userMap.put("ssamurai@codingdojo.com", "Yasar Naser");
		Set<String> keys = userMap.keySet();
		String value = userMap.get("ssamurai@codingdojo.com");
        for(String key : keys) {
            System.out.println("Track :"+ key +" Lyrics :" +userMap.get(key));    
		}
	}
}