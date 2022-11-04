package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Program {

	public static void main(String[] args) throws IOException {
		
		Map<String, Integer> candidatos = new HashMap<>();
		
		String path = "D:\\in.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Integer votos = Integer.parseInt(fields[1]);
				
				if(candidatos.containsKey(name)) {
					int voto = candidatos.get(name);
					candidatos.put(name, votos + voto);
				}else {
					candidatos.put(name, votos);
				}
				
				
				line = br.readLine();
			}
			for(String key : candidatos.keySet()) {
				System.out.println(key + ", " + candidatos.get(key));
			}
		}
		catch(IOException e) {
			System.out.println("Erro ---");
		}
	}

}
