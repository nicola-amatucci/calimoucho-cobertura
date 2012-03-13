package controllers;

import java.util.*;

import play.mvc.*;

import models.*;
import play.Play;

public class Application extends Controller {

    public static void index() {
        List<Result> results = Result.latests();
        
        String runJob = Play.configuration.getProperty("job.run-if-no-results");
        
        if (runJob != null && runJob.equals("true"))
            new jobs.Executor().now();
            
        render(results, runJob);
    }
    
    public static void show(String id) {
        Result result = Result.findByUID(id);
        notFoundIfNull(result);
        render(result);
    }
    
    public static void detail(String id, String test) {
        Result result = Result.findByUID(id);
        String testContent = result.test(test);
        notFoundIfNull(testContent);
        if(test.endsWith(".html")) {
            response.contentType = "text/html";
        }
        renderText(testContent);
    }

    public static void cobertura(String id) {
        Result result = Result.findByUID(id);
        notFoundIfNull(result);
        render(result);
    }
}
