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
    public static void main( String[] args )
    {
//		String input = "This is a test sentence with the word 'this' appearing twice and 'is' is here thrice.";
//		Map<String,Integer> result = exam2(input);
//		System.out.println(result);

		TreeMap<String,Integer> map = new TreeMap<>();

		map.put("this",2);
		map.put("sentence",3);
		map.put("twice",1);
		map.put("gg",5);

		System.out.println(map);
		System.out.println(map.firstEntry());
		for(Map.Entry<String,Integer> entry : map.entrySet()){
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
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
