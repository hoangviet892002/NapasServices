package anotherBank.information.repository.BankRepo;

import anotherBank.information.entities.BankEntity;
import anotherBank.information.repository.BankRepo.operations.BankCreateRepo;
import anotherBank.information.repository.BankRepo.operations.BankDeleteRepo;
import anotherBank.information.repository.BankRepo.operations.BankReadRepo;
import anotherBank.information.repository.BankRepo.operations.BankUpdateRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<BankEntity, Long>,
        BankCreateRepo,
        BankDeleteRepo,
        BankReadRepo,
        BankUpdateRepo
{
}
