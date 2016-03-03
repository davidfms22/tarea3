import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.postgresql.core.Utils;

import dm.uniandes.app.FileFinder;
import dm.uniandes.app.Statistics;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {

	private static String filePath1 = "test1.txt";
	private static String filePath2 = "///Users/davidmars/workspace/Lab4/lab4/src/main/resources/test2.txt";
	private static String filePath3 = "///Users/davidmars/workspace/Lab4/lab4/src/main/resources/test3.txt";
	private static String filePath4 = "///Users/davidmars/workspace/Lab4/lab4/src/main/resources/test4.txt";
	
	
	public static void main(String[] args) {
		
		String mainPath = new File(".").getAbsolutePath().toString();
		
		HashMap<String, List<Double>> data1 = new HashMap<String, List<Double>>();
		try {
			data1 = FileFinder.getPairData(mainPath.replace(".", filePath1));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, Double> result1 = new HashMap<String, Double>();
		result1=Statistics.linearRegression(data1.get("x"), data1.get("y"));
		
		HashMap<String, List<Double>> data2 = new HashMap<String, List<Double>>();
		try {
			data2 = FileFinder.getPairData(filePath2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, Double> result2 = new HashMap<String, Double>();
		result2=Statistics.linearRegression(data2.get("x"), data2.get("y"));
		
		HashMap<String, List<Double>> data3 = new HashMap<String, List<Double>>();
		try {
			data3 = FileFinder.getPairData(filePath3);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, Double> result3 = new HashMap<String, Double>();
		result3=Statistics.linearRegression(data3.get("x"), data3.get("y"));
		
		HashMap<String, List<Double>> data4 = new HashMap<String, List<Double>>();
		try {
			data4 = FileFinder.getPairData(filePath4);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, Double> result4 = new HashMap<String, Double>();
		result4=Statistics.linearRegression(data4.get("x"), data4.get("y"));
		

		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/public");
		String a1 = result1.get("beta0").toString();
		String a2 = result1.get("beta1").toString();
		String a3 = result1.get("rXY").toString();
		String a4 = result1.get("r2").toString();
		String a5 = result1.get("yK").toString();
		String c1 = result2.get("beta0").toString();
		String c2 = result2.get("beta1").toString();
		String c3 = result2.get("rXY").toString();
		String c4 = result2.get("r2").toString();
		String c5 = result2.get("yK").toString();
		String d1 = result3.get("beta0").toString();
		String d2 = result3.get("beta1").toString();
		String d3 = result3.get("rXY").toString();
		String d4 = result3.get("r2").toString();
		String d5 = result3.get("yK").toString();
		String f1 = result4.get("beta0").toString();
		String f2 = result4.get("beta1").toString();
		String f3 = result4.get("rXY").toString();
		String f4 = result4.get("r2").toString();
		String f5 = result4.get("yK").toString();

		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("A1", a1);
			attributes.put("A2", a2);
			attributes.put("A3", a3);
			attributes.put("A4", a4);
			attributes.put("A5", a5);
			attributes.put("C1", c1);
			attributes.put("C2", c2);
			attributes.put("C3", c3);
			attributes.put("C4", c4);
			attributes.put("C5", c5);
			attributes.put("D1", d1);
			attributes.put("D2", d2);
			attributes.put("D3", d3);
			attributes.put("D4", d4);
			attributes.put("D5", d5);
			attributes.put("F1", f1);
			attributes.put("F2", f2);
			attributes.put("F3", f3);
			attributes.put("F4", f4);
			attributes.put("F5", f5);

			return new ModelAndView(attributes, "index.ftl");
		} , new FreeMarkerEngine());

	}

}
