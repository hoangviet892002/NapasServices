package anotherBank.information.controllers.ClientController.Post;

import anotherBank.information.dtos.request.Object.ClientRequest;
import anotherBank.information.dtos.response.BaseResponse;
import anotherBank.information.dtos.response.Object.ClientResponse;
import anotherBank.information.services.ClientService.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Client Controller", description = "Client Controller")
@RequestMapping("/api/v1/client")
public class InsertClient {

    private final ClientService clientService;

    public InsertClient (ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Mono<BaseResponse<ClientResponse>> insertClient(@RequestBody ClientRequest clientRequest) {
        return  clientService.insertClient(clientRequest);
    }

}
