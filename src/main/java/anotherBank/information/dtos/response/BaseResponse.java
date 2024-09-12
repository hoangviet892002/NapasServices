package anotherBank.information.dtos.response;

import anotherBank.information.shared.enums.ResponseEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BaseResponse<T> {
    @JsonProperty("data")
    private T data;
    @JsonProperty("message")
    private String message;
    @JsonProperty("responseCode")
    private String responseCode;

}
