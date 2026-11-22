package kurban.softwareProducts.user.exception;

import kurban.softwareProducts.common.error.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(){
        super("Пользователь не найден");
    }
}
