package market40.arserver.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/entry-point")
public class MainServiceEntryPoint {

    @GET
    @Path("service")
    public String test(String requestBody) {
        String result = "Hallo!\n Just received:"+requestBody;
        return result;
    }
}
