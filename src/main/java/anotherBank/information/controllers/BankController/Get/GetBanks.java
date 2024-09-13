package anotherBank.information.controllers.BankController.Get;


import anotherBank.information.dtos.response.BaseList;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.BankResponse;
import anotherBank.information.services.BankService.BankService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Bank Controller", description = "Bank Controller")
@RequestMapping("/api/v1/bank")
public class GetBanks {
    private final BankService bankService;

    public GetBanks(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public Mono<BaseList<BankResponse>> getBanks(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "size", required = false) String size
    ) {
        return bankService.queryBanks(page, size);
    }
}
