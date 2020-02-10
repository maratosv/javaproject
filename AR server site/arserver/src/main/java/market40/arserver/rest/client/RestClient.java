package market40.arserver.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RestClient {

    public static void main(String[] args) throws Exception {
        sendRequestWithValueParameter();
//        sendRequestWithPayload();
    }

    private static void sendRequestWithValueParameter() throws UnsupportedEncodingException, IOException, ClientProtocolException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpPost = new HttpGet("http://localhost:8088" +
                    "/projects/getAllProjects");

//            List <NameValuePair> nvps = new ArrayList<NameValuePair>();
//            nvps.add(new BasicNameValuePair("value", "THE JSON VALUE"));
//            httpPost.setEntity(new UrlEncodedFormEntity(nvps));

            System.out.println("executing request " + httpPost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                
                if (resEntity != null) {
                    System.out.println("Response content length: " + resEntity.getContentLength());
                    
                    
                    BufferedReader br = null;
                    StringBuilder sb = new StringBuilder();
             
                    String line;
                    br = new BufferedReader(new InputStreamReader(resEntity.getContent()));
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                    System.out.println("Response : \n" + sb.toString());
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }

}
