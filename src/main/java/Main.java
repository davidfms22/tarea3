import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {

	private static String filePath1 = "///C:/GT_Workspace/ECOS/Tarea/program1/Program1/target/test1.txt";

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

		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("A1", "22");
			attributes.put("A2", "22");
			attributes.put("A3", "22");
			attributes.put("A4", "22");
			attributes.put("A5", "22");

			return new ModelAndView(attributes, "index.ftl");
		} , new FreeMarkerEngine());

	}

}
