package anotherBank.information.services.ClientService.impl;

import anotherBank.information.dtos.request.Object.ClientRequest;
import anotherBank.information.dtos.response.BaseList;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.ClientResponse;
import anotherBank.information.services.ClientService.ClientService;
import anotherBank.information.services.ClientService.impl.operations.ClientInsertImpl;
import anotherBank.information.services.ClientService.impl.operations.ClientQueryImpl;
import anotherBank.information.services.ClientService.operations.ClientInsertService;
import anotherBank.information.services.ClientService.operations.ClientQueryService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl  implements ClientService {

    private final ClientInsertImpl clientInsert;
    private final ClientQueryImpl clientQuery;

    public ClientServiceImpl (ClientInsertImpl clientInsert, ClientQueryImpl clientQuery) {
        this.clientInsert = clientInsert;
        this.clientQuery = clientQuery;
    }

    @Override
    public Mono<BaseResponse<ClientResponse>> insertClient(ClientRequest clientRequest) {
        return clientInsert.insertClient(clientRequest);
    }

    @Override
    public Mono<BaseResponse<BaseList<ClientResponse>>> queryClient(String number) {
        return clientQuery.queryClient(number);
    }
}
