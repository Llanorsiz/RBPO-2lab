package kurban.softwareProducts.releaseCheck.mapper;

import kurban.softwareProducts.releaseCheck.model.ReleaseCheck;
import kurban.softwareProducts.releaseCheck.web.request.CreateReleaseCheckRequest;
import kurban.softwareProducts.releaseCheck.web.request.UpdateReleaseCheckRequest;
import kurban.softwareProducts.releaseCheck.web.response.ReleaseCheckResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReleaseCheckMapper {
    ReleaseCheckResponse toReleaseCheckResponse(ReleaseCheck releaseCheck);

    ReleaseCheck fromCreateReleaseCheckRequest(CreateReleaseCheckRequest request);

    void updateFromUpdateReleaseCheckRequest(UpdateReleaseCheckRequest request, @MappingTarget ReleaseCheck releaseCheck);
}
