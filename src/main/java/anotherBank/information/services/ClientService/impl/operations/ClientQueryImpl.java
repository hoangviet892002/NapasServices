package anotherBank.information.services.ClientService.impl.operations;

import anotherBank.information.dtos.response.BaseList;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.BankResponse;
import anotherBank.information.dtos.response.Object.ClientResponse;
import anotherBank.information.mapper.ClientMapper;
import anotherBank.information.repository.ClientRepo.ClientRepo;
import anotherBank.information.services.ClientService.operations.ClientQueryService;
import anotherBank.information.shared.enums.ResponseEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collections;


@Service
public class ClientQueryImpl implements ClientQueryService {

    private final ClientRepo clientRepo;
    private final ClientMapper clientMapper;

    public ClientQueryImpl (ClientRepo clientRepo, ClientMapper clientMapper) {
        this.clientRepo = clientRepo;
        this.clientMapper = clientMapper;
    }


    @Override
    public Mono<ClientResponse> queryClient(String number) {
        try {
            ClientResponse clientResponse = clientMapper.EntityToResponse(clientRepo.findByNumber(number));
            return Mono.just(clientResponse);
        }
        catch (Exception e) {
            return Mono.empty();
        }
    }


}
