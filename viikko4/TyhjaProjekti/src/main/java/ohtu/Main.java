package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "014416884";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2016.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        printStudentData(subs);
    }
    
    private static void printStudentData(Submission[] subs) {
        for (Submission s : subs) {
            StringBuilder sb = new StringBuilder();
            sb.append("Viikko: "+s.getWeek());
            sb.append(" Tehtyjä tehtäviä: "+doneCount(s));
            sb.append(", aikaa kului: "+s.getHours()+" tuntia.");
            System.out.println(sb.toString());
        }
    }
    
    private static int doneCount(Submission s) {
        int count  = 0;
        if (s.isA0()) count++;
        if (s.isA1()) count++;
        if (s.isA2()) count++;
        if (s.isA3()) count++;
        if (s.isA4()) count++;
        if (s.isA5()) count++;
        if (s.isA6()) count++;
        if (s.isA7()) count++;
        if (s.isA8()) count++;
        if (s.isA9()) count++;
        if (s.isA10()) count++;
        if (s.isA11()) count++;
        if (s.isA12()) count++;
        if (s.isA13()) count++;
        if (s.isA14()) count++;
        if (s.isA15()) count++;
        if (s.isA16()) count++;
        if (s.isA17()) count++;
        if (s.isA18()) count++;
        if (s.isA19()) count++;
        if (s.isA20()) count++;
        return count;
    }
    
}