package anotherBank.information.services.BankService.impl.operations;


import anotherBank.information.dtos.response.BaseList;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.BankResponse;
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

    public BankQueryImpl(BankRepo bankRepo, BankMapper bankMapper) {
        this.bankRepo = bankRepo;
        this.bankMapper = bankMapper;
    }

    @Override
    public Mono<BaseResponse<BaseList<BankResponse>>> queryBanks(String page, String size) {
        return validateRequest(page, size)
                .switchIfEmpty(
                       Mono.defer(() ->{
                            try {
                                Page<BankResponse> bankResponses = bankRepo.findAll(PageRequest.of(Integer.parseInt(page), Integer.parseInt(size)))
                                        .map(bankMapper::EntityToResponse);

                                return Mono.just(BaseResponse.<BaseList<BankResponse>>builder()
                                        .responseCode(ResponseEnum.SUCCESS.getCode())
                                        .message(ResponseEnum.SUCCESS.getMessage())
                                        .data(BaseList.<BankResponse>builder()
                                                .items(bankResponses.getContent())
                                                .totalPage(bankResponses.getTotalPages())
                                                .total((int) bankResponses.getTotalElements())
                                                .build())
                                        .build());
                            }
                            catch (Exception e) {
                                return Mono.just(BaseResponse.<BaseList<BankResponse>>builder()
                                        .responseCode(ResponseEnum.INTERNAL_ERROR.getCode())
                                        .message(ResponseEnum.INTERNAL_ERROR.getMessage())
                                        .build());
                            }
                       } )
                );

    }
    public Mono<BaseResponse<BaseList<BankResponse>>> validateRequest(String page, String size) {
       if (page == null || size == null) {
           return  Mono.just(BaseResponse.<BaseList<BankResponse>>builder()
                   .responseCode(ResponseEnum.BAD_REQUEST.getCode())
                   .message(ResponseEnum.BAD_REQUEST.getMessage())
                   .build());
       }
         return Mono.empty();
    }
}
