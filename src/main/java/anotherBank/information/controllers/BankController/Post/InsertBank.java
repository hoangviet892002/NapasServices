package anotherBank.information.controllers.BankController.Post;


import anotherBank.information.dtos.request.Object.BankRequest;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.BankResponse;
import anotherBank.information.services.BankService.BankService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Bank Controller", description = "Bank Controller")
@RequestMapping("/api/v1/bank")
public class InsertBank {

    private final BankService bankService;

    public InsertBank(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping
    public Mono<BaseResponse<BankResponse>> insertBank(@RequestBody BankRequest bankRequest) {
        return  bankService.insertBank(bankRequest);
    }

}
