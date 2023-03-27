package org.example;
/*This class is using the apache velocity template and
*creates (and opens) an HTML report representing the content of the catalog.
* @author Jitca Diana*/
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.log.NullLogChute;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class ReportCommand{

    public void report(Catalog catalog) throws Exception {
        VelocityEngine ve = new VelocityEngine();
        Properties p = new Properties();
        p.put("file.resource.loader.path", "C:\\Users\\jitca\\Desktop\\2.2\\JAVA\\Lab5\\src\\main\\resources");
        ve.init(p);

        Template t = ve.getTemplate("html_example.vm");
        VelocityContext context = new VelocityContext();
        context.put("message", "Welcome to Catalog!");
        context.put("message2", "This is a catalog of documents");

        context.put("catalog", catalog.getDocuments());


        Writer writer = new FileWriter(new File("hello.html"));
        t.merge(context, writer);
        writer.flush();
        writer.close();

    }


}
