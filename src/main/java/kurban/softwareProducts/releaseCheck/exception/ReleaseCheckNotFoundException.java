package kurban.softwareProducts.releaseCheck.exception;

import kurban.softwareProducts.common.error.NotFoundException;

public class ReleaseCheckNotFoundException extends NotFoundException {
    public ReleaseCheckNotFoundException(){
        super("Чек-лист релиза не найден");
    }
}
