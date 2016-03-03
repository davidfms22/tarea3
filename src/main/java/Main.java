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

		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/public");

		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("A1", "beta0");
			attributes.put("A2", "beta1");
			attributes.put("A3", "rXY");
			attributes.put("A4", "R2");
			attributes.put("A5", "Yk");
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
