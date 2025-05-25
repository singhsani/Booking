package Common;

import java.io.Serializable;
public interface EnumType extends Serializable{
    String INVALID_ENUM = "INVALID_ENUM";
    String ENUM_ID = "ID";

    int getId();

    String getName();

    String getType();

    default String getEncodedString(){
        return null;
    }

    //default LookupDataDTO toLookupData() {
     //   return LookupDataDTO.create((long) getId(), getType(), getName());
    //}
}
