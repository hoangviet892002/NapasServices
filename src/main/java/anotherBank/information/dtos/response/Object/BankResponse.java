package anotherBank.information.dtos.response.Object;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BankResponse {
    @JsonProperty
    private String bankName;
    @JsonProperty
    private String bankCode;
}
