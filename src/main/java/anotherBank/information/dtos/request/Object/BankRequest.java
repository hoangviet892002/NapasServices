package anotherBank.information.dtos.request.Object;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BankRequest {
    @JsonProperty("bankName")
    private String bankName;
    @JsonProperty("bankCode")
    private String bankCode;
}
