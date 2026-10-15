package kurban.softwareProducts.softwareProduct.mapper;

import kurban.softwareProducts.softwareProduct.model.SoftwareProduct;
import kurban.softwareProducts.softwareProduct.web.request.CreateSoftwareProductRequest;
import kurban.softwareProducts.softwareProduct.web.request.UpdateSoftwareProductRequest;
import kurban.softwareProducts.softwareProduct.web.response.SoftwareProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SoftwareProductMapper {
    SoftwareProductResponse toSoftwareProductResponse(SoftwareProduct softwareProduct);

    SoftwareProduct fromCreateSoftwareProductRequest(CreateSoftwareProductRequest request);

    void updateFromUpdateSoftwareProductRequest(UpdateSoftwareProductRequest request, @MappingTarget SoftwareProduct softwareProduct);
}
