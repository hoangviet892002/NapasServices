package anotherBank.information.services.BankService.impl.operations;

import anotherBank.information.dtos.request.Object.BankRequest;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.BankResponse;
import anotherBank.information.entities.BankEntity;
import anotherBank.information.mapper.BankMapper;
import anotherBank.information.repository.BankRepo.BankRepo;
import anotherBank.information.services.BankService.operations.BankInsertService;
import anotherBank.information.shared.enums.ResponseEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BankInsertImpl implements BankInsertService {
    private final BankRepo bankRepo;
    private final BankMapper bankMapper;

    @Override
    public Mono<BaseResponse<BankResponse>> insertBank(BankRequest bankRequest) {
        try {
            if (bankRepo.findBankByName(bankRequest.getBankName()) != null) {
                return Mono.just(BaseResponse.<BankResponse>builder()
                        .message(ResponseEnum.BIZ_ERROR.getMessage())
                        .responseCode(ResponseEnum.BIZ_ERROR.getCode())
                        .build());
            }
            BankEntity newBank = bankRepo.save(bankMapper.RequestToEntity(bankRequest));
            return Mono.just(BaseResponse.<BankResponse>builder()
                    .message(ResponseEnum.SUCCESS.getMessage())
                    .responseCode(ResponseEnum.SUCCESS.getCode())
                    .data(bankMapper.EntityToResponse(newBank))
                    .build());
        } catch (Exception e) {
            return Mono.just(BaseResponse.<BankResponse>builder()
                    .message(ResponseEnum.INTERNAL_ERROR.getMessage())
                    .responseCode(ResponseEnum.INTERNAL_ERROR.getCode())
                    .build());
        }
    }


}
