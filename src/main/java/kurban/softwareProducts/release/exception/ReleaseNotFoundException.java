package kurban.softwareProducts.release.exception;

import kurban.softwareProducts.common.error.NotFoundException;

public class ReleaseNotFoundException extends NotFoundException {
    public ReleaseNotFoundException(){
        super("Релиз не найден");
    }
}
