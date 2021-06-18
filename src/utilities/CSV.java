package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {

	// csv file to list
	public static List<String[]> read(String file) throws FileNotFoundException {
		List<String[]> data = new LinkedList<String[]>();
		String dataRow;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			while ((dataRow = br.readLine()) != null) {
				String[] dataRec = dataRow.split(",");
				data.add(dataRec);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("COULD NOT READ FILE !");
			e.printStackTrace();
		}

		return data;
	}

}
