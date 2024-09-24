package anotherBank.information.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
@Entity
public class BankEntity extends BaseEntity{

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClientEntity> clientEntityList;

}
