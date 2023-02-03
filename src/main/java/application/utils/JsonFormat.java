package application.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JsonFormat {

    public static ResponseEntity<Object> build (Object object){
        return build(object, HttpStatus.OK);

    }

    public static ResponseEntity <Object> build (Object object, HttpStatus status){
    Map <String,Object> map = new LinkedHashMap<>();
    map.put("data", object);
        return new ResponseEntity<>(map,status);

    }    

   

}
