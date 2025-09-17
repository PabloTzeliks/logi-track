package pablo.tzeliks.domain.model.vo;

public interface Document {

    String getValue();
    String getFormattedValue();
    boolean validate(String value);

}
