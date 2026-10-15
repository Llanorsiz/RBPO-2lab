package kurban.softwareProducts.release.mapper;

import kurban.softwareProducts.release.model.Release;
import kurban.softwareProducts.release.web.request.CreateReleaseRequest;
import kurban.softwareProducts.release.web.request.UpdateReleaseRequest;
import kurban.softwareProducts.release.web.response.ReleaseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReleaseMapper {
    ReleaseResponse toReleaseResponse(Release release);

    Release fromCreateReleaseRequest(CreateReleaseRequest request);

    void updateFromUpdateReleaseRequest(UpdateReleaseRequest request, @MappingTarget Release release);
}
