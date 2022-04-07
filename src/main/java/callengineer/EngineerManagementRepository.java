package callengineer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="engineerManagements", path="engineerManagements")
public interface EngineerManagementRepository extends PagingAndSortingRepository<EngineerManagement, Long>{


}
