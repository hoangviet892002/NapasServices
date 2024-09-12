package anotherBank.information.services.BankService.impl;

import anotherBank.information.dtos.request.Object.BankRequest;
import anotherBank.information.dtos.response.BaseList;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.BankResponse;
import anotherBank.information.mapper.BankMapper;
import anotherBank.information.repository.BankRepo.BankRepo;
import anotherBank.information.services.BankService.BankService;
import anotherBank.information.services.BankService.impl.operations.BankInsertImpl;
import anotherBank.information.services.BankService.impl.operations.BankQueryImpl;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class BankServiceImpl implements BankService {
    private final BankInsertImpl bankInsertImpl;
    private final BankQueryImpl bankQueryImpl;
    public BankServiceImpl( BankInsertImpl bankInsertImpl, BankQueryImpl bankQueryImpl) {
        this.bankInsertImpl = bankInsertImpl;
        this.bankQueryImpl = bankQueryImpl;
    }

    @Override
    public Mono<BaseResponse<BankResponse>> insertBank(BankRequest bankRequest) {
        return bankInsertImpl.insertBank(bankRequest);
    }

    @Override
    public Mono<BaseResponse<BaseList<BankResponse>>> queryBanks(String page, String size) {
        return bankQueryImpl.queryBanks(page, size);
    }
}
