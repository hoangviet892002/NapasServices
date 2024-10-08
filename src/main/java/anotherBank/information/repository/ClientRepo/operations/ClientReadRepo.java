package anotherBank.information.repository.ClientRepo.operations;

import anotherBank.information.entities.ClientEntity;

public interface ClientReadRepo {
    ClientEntity findByName (String name);
    ClientEntity findByNumberAndBankCode(String number, String bank);
}
