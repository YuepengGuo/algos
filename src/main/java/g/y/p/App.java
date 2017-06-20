package g.y.p;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Integer i = new Integer(1^2^3^4^5^6^7^7);
        System.out.println(Integer.toBinaryString(i));
	}
	public static Map<String,Integer> exam(String input){
		String separator = "\\s";
		String puncs = "\\p{Punct}";
		String[] tokens = input.replaceAll(puncs,"").split(separator);
		Map<String,Integer> map = new HashMap<>();

		for(int i=0;i<tokens.length;i++){
			String token = tokens[i];
			if(map.containsKey(token)){
				Integer preValue = map.get(token);
				map.put(token,preValue+1);
			}else{
				map.put(token,1);
			}
		}

		return map;
	}

	public static Map<String,Integer> exam2(String input){
		String separator = "\\s";
		String puncs = "\\p{Punct}";
		String[] tokens = input.replaceAll(puncs,"").split(separator);
		SortedMap<String,Integer> map = new TreeMap<>();


		for(int i=0;i<tokens.length;i++){
			String token = tokens[i];
			if(map.containsKey(token)){
				Integer preValue = map.get(token);
				map.put(token,preValue+1);
			}else{
				map.put(token,1);
			}
		}

		return map;
	}
}
