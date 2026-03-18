package rs.ac.singidunum.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SellerModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String umcn;
    private String taxId;
}