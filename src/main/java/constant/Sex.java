package constant;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Sex implements BaseEnumConstant {
    MALE(1, "男"),
    FEMALE(2, "女"),
    OTHER(3, "其他");

    private int code;
    private String text;

    Sex(int code, String text) {
        this.code = code;
        this.text = text;
    }

    @Override
    public EnumObj getJsonObj() {
        return new EnumObj(code, text);
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @JsonCreator
    public static Sex getItemByCode(int code) {
        for (Sex sex : values()) {
            if (sex.getCode() == code) {
                return sex;
            }
        }
        return null;
    }
}