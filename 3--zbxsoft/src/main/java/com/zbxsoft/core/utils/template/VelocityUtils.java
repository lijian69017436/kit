 package com.zbxsoft.core.utils.template;
 
 import java.io.StringWriter;
 import java.util.Map;
 import org.apache.velocity.VelocityContext;
 import org.apache.velocity.app.Velocity;
 import org.apache.velocity.app.VelocityEngine;
 
 public abstract class VelocityUtils
 {
   public static String renderTemplateContent(String templateContent, Map<String, ?> context)
   {
     VelocityContext velocityContext = new VelocityContext(context);
 
     StringWriter result = new StringWriter();
     Velocity.evaluate(velocityContext, result, "", templateContent);
     return result.toString();
   }
 
   public static String renderFile(String templateFilePName, VelocityEngine velocityEngine, String encoding, Map<String, ?> context)
   {
     VelocityContext velocityContext = new VelocityContext(context);
 
     StringWriter result = new StringWriter();
     velocityEngine.mergeTemplate(templateFilePName, encoding, velocityContext, result);
     return result.toString();
   }
 
   static
   {
     Velocity.init();
   }
 }

