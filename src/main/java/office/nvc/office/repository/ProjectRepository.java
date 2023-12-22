package office.nvc.office.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import office.nvc.office.model.Project;

public interface ProjectRepository extends CrudRepository<Project,Integer> {
    List<Project> findByNameContaining(String name);
}
