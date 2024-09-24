package anotherBank.information.controllers.ClientController.Get;

import anotherBank.information.dtos.response.BaseList;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.BankResponse;
import anotherBank.information.dtos.response.Object.ClientResponse;
import anotherBank.information.services.ClientService.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Client Controller", description = "Client Controller")
@RequestMapping("/api/v1/client")
public class GetClient {

    private final ClientService clientService;

    public GetClient (ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public Mono<ClientResponse> getClient(@RequestParam String number, @RequestParam String bank) {
        return clientService.queryClient(number, bank);
    }

}
