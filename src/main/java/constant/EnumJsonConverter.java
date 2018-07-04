package constant;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public interface EnumJsonConverter {

    @JsonValue
    EnumObj getJsonObj();

    @Getter
    @Setter
    @AllArgsConstructor
    class EnumObj{
        private int value;
        private String text;
    }
}
