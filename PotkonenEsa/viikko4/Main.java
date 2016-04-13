package ohtu;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		String studentNr = "011120649";
		if (args.length > 0) {
			studentNr = args[0];
		}

		String url = "http://ohtustats2016.herokuapp.com/students/" + studentNr + "/submissions";

		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		try {
			client.executeMethod(method);

			InputStream stream = method.getResponseBodyAsStream();

			String bodyText = IOUtils.toString(stream);

			System.out.format("opiskelijanumero %s\n\n",studentNr);

			Gson mapper = new Gson();
			Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

			int hoursTotal = 0;
			int excersizesTotal = 0;
			for (Submission submission : subs) {
				String[] done = submission.done();
				hoursTotal += Integer.parseInt(submission.getHours());
				excersizesTotal += Integer.parseInt(done[0]);
				System.out.format(" viikko %s: tehtyjä tehtäviä yhteensä: %s, aikaa kului %s tuntia, tehdyt tehtävät:%s\n",submission.getWeek(),done[0],submission.getHours(),done[1]);
			}

			System.out.format("\nyhteensä: %d tehtävää %d tuntia ",excersizesTotal,hoursTotal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void printSubmission(Submission s) {
	}
	public static void printFields(String bodyText) throws ParseException {
		JSONParser parser = new JSONParser();
		JSONArray  json = (JSONArray ) parser.parse(bodyText);
		
		for(Object j: json) {
			JSONObject jo = (JSONObject) j;
			Set<?> keys = (Set<?>) jo.keySet();

			for(Object i : keys) {
				System.out.println("private String "+i+";");
			}	
			break;
		}
		
	}
}
