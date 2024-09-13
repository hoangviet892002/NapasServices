package anotherBank.information.services.BankService.impl.operations;


import anotherBank.information.dtos.response.BaseList;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.BankResponse;
import anotherBank.information.entities.BankEntity;
import anotherBank.information.mapper.BankMapper;
import anotherBank.information.repository.BankRepo.BankRepo;
import anotherBank.information.services.BankService.operations.BankQueryService;
import anotherBank.information.shared.enums.ResponseEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
public class BankQueryImpl implements BankQueryService {

    private final BankRepo bankRepo;
    private final BankMapper bankMapper;

    private static final String DEFAULT_PAGE = "0";
    private static final String DEFAULT_SIZE = "10";

    public BankQueryImpl(BankRepo bankRepo, BankMapper bankMapper) {
        this.bankRepo = bankRepo;
        this.bankMapper = bankMapper;
    }

    @Override
    public Mono<BaseList<BankResponse>> queryBanks(String page, String size) {
        if (page == null || size == null) {
            page = DEFAULT_PAGE;
            size = DEFAULT_SIZE;
        }
        try {
            Page<BankResponse> bankResponses = bankRepo.findAll(PageRequest.of(Integer.parseInt(page), Integer.parseInt(size)))
                    .map(bankMapper::EntityToResponse);

            return Mono.just(BaseList.<BankResponse>builder()
                            .data(bankResponses.getContent())
                            .totalPage(bankResponses.getTotalPages())
                            .page(Integer.parseInt(page))
                            .totalPage(bankResponses.getTotalPages())
                            .totalRecord((int) bankResponses.getTotalElements())
                    .build());

        }
        catch (Exception e) {
            return Mono.just(BaseList.<BankResponse>builder()
                    .data(Collections.emptyList())
                    .totalPage(0)
                    .page(Integer.parseInt(page))
                    .totalRecord(0)
                    .build());
        }
    }

    @Override
    public Mono<Boolean> checkBankExist(String bankId) {
        BankEntity bankEntity = bankRepo.findByCode(bankId);
        return Mono.just(bankEntity != null);
    }
}
