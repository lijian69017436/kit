 package com.zbxsoft.core.utils.validator;
 
 import com.google.common.collect.Lists;
 import java.util.List;
 import java.util.Set;
 import javax.validation.ConstraintViolation;
 import javax.validation.ConstraintViolationException;
 import javax.validation.Validator;
 import org.apache.commons.lang.StringUtils;
 
 public class ValidatorUtils
 {
   public static void validateWithException(Validator validator, Object object, Class<?>[] groups)
     throws ConstraintViolationException
   {
     Set constraintViolations = validator.validate(object, groups);
     if (!constraintViolations.isEmpty())
       throw new ConstraintViolationException(constraintViolations);
   }
 
   public static String convertMessage(Set<? extends ConstraintViolation> constraintViolations, String separator)
   {
     List errorMessages = Lists.newArrayList();
     for (ConstraintViolation violation : constraintViolations) {
       errorMessages.add(violation.getMessage());
     }
     return StringUtils.join(errorMessages, separator);
   }
 
   public static String convertMessage(ConstraintViolationException e, String separator)
   {
     return convertMessage(e.getConstraintViolations(), separator);
   }
 }

