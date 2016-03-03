package dm.uniandes.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class FileFinder {

	public static LinkedList<Double> getData(String filePath) throws FileNotFoundException, IOException {
		String num;
		FileReader file = new FileReader(filePath);
		BufferedReader linesFile = new BufferedReader(file);
		LinkedList<Double> data = new LinkedList<Double>();

		while ((num = linesFile.readLine()) != null) {
			if (!num.equals("")) {
				data.add(Double.parseDouble(num));
			}

		}
		linesFile.close();
		return data;
	}
	
	public static HashMap<String, List<Double>> getPairData(String filePath) throws FileNotFoundException, IOException {
		
		FileReader file = new FileReader(filePath);
		BufferedReader linesFile = new BufferedReader(file);
		String line;
		List<Double> x = new ArrayList<Double>();
		List<Double> y = new ArrayList<Double>();

		while ((line = linesFile.readLine()) != null) {
			if (!line.equals("")) {
				String nums[]=line.split("-");
				x.add(Double.parseDouble(nums[0]));
				y.add(Double.parseDouble(nums[1]));
			}

		}
		linesFile.close();
        
        HashMap<String, List<Double>> pairData = new HashMap<String, List<Double>>();
        pairData.put("x", x);
        pairData.put("y", y);
        
        return pairData;
	}

}
