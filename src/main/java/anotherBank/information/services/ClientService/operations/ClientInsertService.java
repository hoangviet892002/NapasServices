package anotherBank.information.services.ClientService.operations;

import anotherBank.information.dtos.request.Object.ClientRequest;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.ClientResponse;
import reactor.core.publisher.Mono;

public interface ClientInsertService {
    Mono<BaseResponse<ClientResponse>> insertClient(ClientRequest clientRequest);
}
