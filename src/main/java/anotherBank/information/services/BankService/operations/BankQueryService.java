package anotherBank.information.services.BankService.operations;

import anotherBank.information.dtos.response.BaseList;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.BankResponse;
import reactor.core.publisher.Mono;

public interface BankQueryService {
    Mono<BaseResponse<BaseList<BankResponse>>> queryBanks(String page, String size);
}
