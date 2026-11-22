package kurban.softwareProducts.softwareProduct.exception;

import kurban.softwareProducts.common.error.NotFoundException;

public class SoftwareProductNotFoundException extends NotFoundException {
    public SoftwareProductNotFoundException(){
        super("Продукт не найден");
    }
}
