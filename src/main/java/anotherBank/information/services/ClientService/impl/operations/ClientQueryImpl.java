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
    public Mono<BaseResponse<BaseList<ClientResponse>>> queryClient(String number) {
        return Mono.fromCallable(() -> clientRepo.findByNumber(number))
                .map(clientEntity -> {
                    if (clientEntity == null) {
                        return BaseResponse.<BaseList<ClientResponse>>builder()
                                .responseCode(ResponseEnum.DATA_NOT_FOUND.getCode())
                                .message("Client not found")
                                .data(BaseList.<ClientResponse>builder()
                                        .items(Collections.emptyList())
                                        .totalPage(0)
                                        .total(0)
                                        .build())
                                .build();
                    } else {
                        ClientResponse clientResponse = clientMapper.EntityToResponse(clientEntity);
                        return BaseResponse.<BaseList<ClientResponse>>builder()
                                .responseCode(ResponseEnum.SUCCESS.getCode())
                                .message(ResponseEnum.SUCCESS.getMessage())
                                .data(BaseList.<ClientResponse>builder()
                                        .items(Collections.singletonList(clientResponse))
                                        .totalPage(1)
                                        .total(1)
                                        .build())
                                .build();
                    }
                })
                .onErrorResume(e -> Mono.just(BaseResponse.<BaseList<ClientResponse>>builder()
                        .responseCode(ResponseEnum.INTERNAL_ERROR.getCode())
                        .message(ResponseEnum.INTERNAL_ERROR.getMessage())
                        .data(BaseList.<ClientResponse>builder()
                                .items(Collections.emptyList())
                                .totalPage(0)
                                .total(0)
                                .build())
                        .build()));
    }


}
