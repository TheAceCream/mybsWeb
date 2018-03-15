package com.mybs.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.codehaus.plexus.util.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AceCream on 2018/3/15.
 */
public class StringToDateDeserializer extends JsonDeserializer<Date> {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (StringUtils.isNotBlank(jsonParser.getValueAsString())){
            try {
                Date parse = sdf.parse(jsonParser.getValueAsString());
                return parse;
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }


}
