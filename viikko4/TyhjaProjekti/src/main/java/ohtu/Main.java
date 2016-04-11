package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import ohtu.Submission;

public class Main {
    public static void main(String[] args) throws IOException {
        String studentNr = "014420809";
        
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

        // Tulostus
        System.out.println("Opiskelijanumero: " + studentNr);
        System.out.println("");
        int hours = 0;
        int howManyDone = 0;
        for(int i = 0; i < subs.length; i++){
            System.out.println(subs[i]);
            hours += subs[i].getHours();
            howManyDone += subs[i].howManyDone();
        }
        System.out.println("");
        System.out.println("Yhteensä kului " + hours + " tuntia ja " + howManyDone + " tehtävää oli tehtynä");
    }
}
