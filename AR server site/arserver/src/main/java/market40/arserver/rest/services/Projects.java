package market40.arserver.rest.services;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import market40.arserver.rest.services.dto.Project;

@Path("/projects")
public class Projects {
	
	@GET
    @Path("getAllProjects")
    public List<Project> getAllProjects(String requestBody) {
		List<Project> result = new ArrayList<Project>();
		List<BufferedImage> images = new ArrayList<BufferedImage>();
		
		Project p = new Project();		
		p.setId("1"); p.setMachineName("Machine1");
		p.setCompanyName("PrimaCV");
		p.setId("2"); p.setMachineName("Machine2");
		p.setCompanyName("PrimaCO");
		
	//	p.setRating(1,4);
//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//		InputStream input = classLoader.getResourceAsStream("image.jpg");
//		Image logo = ImageIO.read(input);
		
	//	File file = new File("AR server site/arserver/machinesphotos/");
		//BufferedImage image = ImageIO.read(machine1.jpg);
		
		File file = new File("AR server site/arserver/machinesphotos/");
		BufferedImage image = null;
		
       
         
        try
        {
        	
            image = ImageIO.read(file);
             
            ImageIO.write(image, "jpg", new File("I:/machine2.jpg"));        
            images.add(image);
             
            ImageIO.write(image, "png", new File("I:/machine1.png"));
            images.add(image);
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
         
        System.out.println("done");
        





       
        
		
		
		result.add(p);		
        return result;
    }	

}
