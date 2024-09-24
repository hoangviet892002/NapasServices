package anotherBank.information.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
@Entity
public class ClientEntity extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private String number;
    @ManyToOne
    @JoinColumn(name = "bank_code", referencedColumnName = "code")
    private BankEntity bank;

}
