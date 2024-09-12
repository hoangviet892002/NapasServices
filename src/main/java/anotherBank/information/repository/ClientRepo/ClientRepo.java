package anotherBank.information.repository.ClientRepo;

import anotherBank.information.entities.ClientEntity;
import anotherBank.information.repository.ClientRepo.operations.ClientCreateRepo;
import anotherBank.information.repository.ClientRepo.operations.ClientDeleteRepo;
import anotherBank.information.repository.ClientRepo.operations.ClientReadRepo;
import anotherBank.information.repository.ClientRepo.operations.ClientUpdateRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<ClientEntity, Long>,
        ClientCreateRepo,
        ClientDeleteRepo,
        ClientReadRepo,
        ClientUpdateRepo {
}
