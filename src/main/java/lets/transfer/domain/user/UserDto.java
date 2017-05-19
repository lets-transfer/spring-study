package lets.transfer.domain.user;

import lombok.Data;

@Data
public class UserDto {

    private String name;
    private String address;
    private String phone;
    private String product;
    private int amount;
}
