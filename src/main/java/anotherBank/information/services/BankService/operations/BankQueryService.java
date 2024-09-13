package anotherBank.information.services.BankService.operations;

import anotherBank.information.dtos.response.BaseList;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.BankResponse;
import anotherBank.information.entities.BankEntity;
import reactor.core.publisher.Mono;

public interface BankQueryService {
    Mono<BaseList<BankResponse>> queryBanks(String page, String size);


    Mono<Boolean>  checkBankExist(String bankId);
}
