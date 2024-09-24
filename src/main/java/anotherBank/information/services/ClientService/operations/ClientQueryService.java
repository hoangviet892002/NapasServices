package anotherBank.information.services.ClientService.operations;

import anotherBank.information.dtos.response.BaseList;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.ClientResponse;
import reactor.core.publisher.Mono;

public interface ClientQueryService {
    Mono<ClientResponse> queryClient(String number, String bank);
}
