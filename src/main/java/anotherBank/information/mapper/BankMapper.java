package anotherBank.information.mapper;

import anotherBank.information.dtos.request.Object.BankRequest;
import anotherBank.information.dtos.response.Object.BankResponse;
import anotherBank.information.entities.BankEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BankMapper {
    public BankEntity RequestToEntity(BankRequest bankRequest) {
        BankEntity bankEntity = new BankEntity();
        bankEntity.setName(bankRequest.getBankName());
        bankEntity.setCode(bankRequest.getBankCode());
        return bankEntity;
    }


    public BankResponse EntityToResponse(BankEntity bankEntity) {
        BankResponse bankResponse = new BankResponse();
        bankResponse.setBankName(bankEntity.getName());
        bankResponse.setBankCode(bankEntity.getCode());
        return bankResponse;
    }
    public List<BankResponse> EntityListToResponseList(List<BankEntity> bankEntities) {
        return bankEntities.stream().map(this::EntityToResponse).collect(Collectors.toList());
    }
    public List<BankEntity> RequestListToEntityList(List<BankRequest> bankRequests) {
        return bankRequests.stream().map(this::RequestToEntity).collect(Collectors.toList());
    }
}
