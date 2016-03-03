import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dm.uniandes.app.FileFinder;
import dm.uniandes.app.Statistics;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {

	private static String filePath1 = "//Users/davidmars/workspace/Lab4/lab4/target/test1.txt";
	
	public static void main(String[] args) {
		
		HashMap<String, List<Double>> data1 = new HashMap<String, List<Double>>();
		try {
			data1 = FileFinder.getPairData(filePath1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, Double> result1 = new HashMap<String, Double>();
		result1=Statistics.linearRegression(data1.get("x"), data1.get("y"));
		

		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/public");
		String a1 = result1.get("beta0").toString();
		String a2 = result1.get("beta1").toString();
		String a3 = result1.get("rXY").toString();
		String a4 = result1.get("r2").toString();
		String a5 = result1.get("yK").toString();

		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("A1", a1);
			attributes.put("A2", a2);
			attributes.put("A3", a3);
			attributes.put("A4", a4);
			attributes.put("A5", a5);
			attributes.put("C1", "beta0");
			attributes.put("C2", "beta1");
			attributes.put("C3", "rXY");
			attributes.put("C4", "R2");
			attributes.put("C5", "Yk");
			attributes.put("D1", "beta0");
			attributes.put("D2", "beta1");
			attributes.put("D3", "rXY");
			attributes.put("D4", "R2");
			attributes.put("D5", "Yk");
			attributes.put("F1", "beta0");
			attributes.put("F2", "beta1");
			attributes.put("F3", "rXY");
			attributes.put("F4", "R2");
			attributes.put("F5", "Yk");

			return new ModelAndView(attributes, "index.ftl");
		} , new FreeMarkerEngine());

	}

}
