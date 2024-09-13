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
public class ClientRequest {

    @JsonProperty("clientName")
    private String clientName;

    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("bankId")
    private String bankId;

}
