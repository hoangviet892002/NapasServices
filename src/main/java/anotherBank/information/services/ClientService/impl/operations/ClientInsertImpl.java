package anotherBank.information.services.ClientService.impl.operations;

import anotherBank.information.dtos.request.Object.ClientRequest;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.BankResponse;
import anotherBank.information.dtos.response.Object.ClientResponse;
import anotherBank.information.entities.ClientEntity;
import anotherBank.information.mapper.ClientMapper;
import anotherBank.information.repository.ClientRepo.ClientRepo;
import anotherBank.information.services.BankService.BankService;
import anotherBank.information.services.ClientService.operations.ClientInsertService;
import anotherBank.information.shared.enums.ResponseEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ClientInsertImpl implements ClientInsertService {

    private final ClientRepo clientRepo;
    private final ClientMapper clientMapper;
    private final BankService bankService;

    @Override
    public Mono<BaseResponse<ClientResponse>> insertClient(ClientRequest clientRequest) {
        try {
            if (clientRepo.findByName(clientRequest.getClientName()) != null) {
                return Mono.just(BaseResponse.<ClientResponse>builder()
                        .message(ResponseEnum.BIZ_ERROR.getMessage())
                        .responseCode(ResponseEnum.BIZ_ERROR.getCode())
                        .build());
            }
            if (!Boolean.TRUE.equals(bankService.checkBankExist(clientRequest.getBankId()).block())) {
                return Mono.just(BaseResponse.<ClientResponse>builder()
                        .message(ResponseEnum.BIZ_ERROR.getMessage())
                        .responseCode(ResponseEnum.BIZ_ERROR.getCode())
                        .build());
            }

            ClientEntity newClient = clientRepo.save(clientMapper.RequestToEntity(clientRequest));

            return Mono.just(BaseResponse.<ClientResponse>builder()
                    .message(ResponseEnum.SUCCESS.getMessage())
                    .responseCode(ResponseEnum.SUCCESS.getCode())
                    .data(clientMapper.EntityToResponse(newClient))
                    .build());
        } catch (Exception e) {
            return Mono.just(BaseResponse.<ClientResponse>builder()
                    .message(ResponseEnum.INTERNAL_ERROR.getMessage())
                    .responseCode(ResponseEnum.INTERNAL_ERROR.getCode())
                    .build());
        }
    }

}
