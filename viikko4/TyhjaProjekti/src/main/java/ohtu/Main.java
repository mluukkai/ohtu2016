package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "014614288";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2016.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);
        
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        System.out.println("Opiskelijanumero " + studentNr + "\n");
        
        int totalExercises = 0;
        int hours = 0;
        
        for (Submission submission : subs) {
            System.out.println(submission);
            totalExercises += Integer.parseInt(submission.getDoneData()[0]);
            hours += submission.getHours();
        }
        
        System.out.println("\nyhteensä: " + totalExercises + " tehtävää, " + hours + " tuntia");

    }
}