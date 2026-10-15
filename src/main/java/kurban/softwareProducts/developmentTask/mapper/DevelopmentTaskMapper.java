package kurban.softwareProducts.developmentTask.mapper;

import kurban.softwareProducts.developmentTask.model.DevelopmentTask;
import kurban.softwareProducts.developmentTask.web.request.CreateDevelopmentTaskRequest;
import kurban.softwareProducts.developmentTask.web.request.UpdateDevelopmentTaskRequest;
import kurban.softwareProducts.developmentTask.web.response.DevelopmentTaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DevelopmentTaskMapper {
    DevelopmentTaskResponse toDevelopmentTaskResponse(DevelopmentTask developmentTask);

    DevelopmentTask fromCreateDevelopmentTaskRequest(CreateDevelopmentTaskRequest request);

    void updateFromUpdateDevelopmentTaskRequest(UpdateDevelopmentTaskRequest request, @MappingTarget DevelopmentTask developmentTask);
}
