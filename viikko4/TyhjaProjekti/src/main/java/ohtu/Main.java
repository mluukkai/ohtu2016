package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length<1) {
            System.out.println("Please give a student number as a parameter");
            return;
        }
        String studentNr = args[0];
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

        System.out.println(studentNr + ": viikoittaiset tehtävät:");
        int completed=0;
        int hours=0;
        for (Submission submission : subs) {
            completed +=submission.completedAssignments();
            hours+=submission.getHours();
            System.out.println(submission);
        }
        System.out.println("Tehtäviä tehty yhteensä: " + completed);
        System.out.println("Tunteja käytetty yhteensä: " + hours);

    }
}