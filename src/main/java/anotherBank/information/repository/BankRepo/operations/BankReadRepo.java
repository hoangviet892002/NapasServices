package anotherBank.information.repository.BankRepo.operations;

import anotherBank.information.entities.BankEntity;

public interface BankReadRepo {
    BankEntity findBankByName(String name);

    BankEntity findById(String id);

    BankEntity findByCode(String code);
}
