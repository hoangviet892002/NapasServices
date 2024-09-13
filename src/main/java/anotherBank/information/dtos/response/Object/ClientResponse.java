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
public class ClientResponse {

    @JsonProperty
    private String clientName;

    @JsonProperty
    private String accountNumber;

}
