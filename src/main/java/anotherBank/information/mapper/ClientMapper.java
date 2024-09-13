package anotherBank.information.mapper;

import anotherBank.information.dtos.request.Object.ClientRequest;
import anotherBank.information.dtos.response.Object.ClientResponse;
import anotherBank.information.entities.ClientEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public ClientEntity RequestToEntity (ClientRequest clientRequest) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(clientRequest.getClientName());
        clientEntity.setNumber(clientRequest.getAccountNumber());

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
