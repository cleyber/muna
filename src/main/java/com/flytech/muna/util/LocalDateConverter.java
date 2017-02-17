package com.flytech.muna.util;

import java.sql.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date>{

   @Override
   public Date convertToDatabaseColumn(LocalDate locDate){
      if(locDate != null) return Date.valueOf(locDate); else return null;
   }

   @Override
   public LocalDate convertToEntityAttribute(Date sqlDate){
      if(sqlDate != null) return sqlDate.toLocalDate(); else return null;
   }
}
