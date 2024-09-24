package anotherBank.information.mapper;

import anotherBank.information.dtos.request.Object.ClientRequest;
import anotherBank.information.dtos.response.Object.ClientResponse;
import anotherBank.information.entities.BankEntity;
import anotherBank.information.entities.ClientEntity;
import anotherBank.information.repository.BankRepo.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    private final BankRepo bankRepo;

    @Autowired
    public ClientMapper(BankRepo bankRepo) {
        this.bankRepo = bankRepo;
    }

    public ClientEntity RequestToEntity(ClientRequest clientRequest) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(clientRequest.getClientName());
        clientEntity.setNumber(clientRequest.getAccountNumber());

        BankEntity bankEntity = bankRepo.findByCode(clientRequest.getBankId());
        System.out.println(clientRequest.getBankId());
        clientEntity.setBank(bankEntity);

        return clientEntity;
    }

    public List<ClientEntity> RequestListToEntityList(List<ClientRequest> clientRequests) {
        return clientRequests.stream().map(this::RequestToEntity).collect(Collectors.toList());
    }

    public ClientResponse EntityToResponse (ClientEntity clientEntity) {
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setClientName(clientEntity.getName());
        clientResponse.setAccountNumber(clientEntity.getNumber());

        return  clientResponse;
    }

    public List<ClientResponse> EntityListToResponseList(List<ClientEntity> clientEntities) {
        return clientEntities.stream().map(this::EntityToResponse).collect(Collectors.toList());
    }
}
