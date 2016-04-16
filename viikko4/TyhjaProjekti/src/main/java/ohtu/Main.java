package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "014257441";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2016.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        
        //System.out.println("Oliot:");
        System.out.println("Opiskelijanumero: "+studentNr);
        System.out.println("");
        int tuntilaskuri=0;
        int tehtavalaskuri=0;
        
        for (Submission submission : subs) {
            //String str = submission.toString();
            System.out.println(submission);
            tuntilaskuri+=submission.getHours();
            tehtavalaskuri+=submission.getTasksDone();
            
//            for (int i = 0; i<str.length(); i++) {
//                if (str.charAt(i)==',' && str.charAt(i-1)==',') {
//                    i++;
//                } 
//                else (str.charAt)
//            }
        }
        System.out.println("");
        System.out.println("Yhteensä: "+tehtavalaskuri+" tehtävää, "+tuntilaskuri+" tuntia");
    }
}