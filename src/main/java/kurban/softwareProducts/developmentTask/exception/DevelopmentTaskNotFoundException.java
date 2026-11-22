package kurban.softwareProducts.developmentTask.exception;

import kurban.softwareProducts.common.error.NotFoundException;

public class DevelopmentTaskNotFoundException extends NotFoundException {
    public DevelopmentTaskNotFoundException(){
        super("Задача не найден");
    }
}