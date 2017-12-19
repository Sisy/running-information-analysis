package demo.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(path = "runningInformation")
public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long> {

    @Override
    Page<RunningInformation> findAll(Pageable pageable);

    @RestResource(path = "runningId")
    Page<RunningInformation> findByRunningId(@Param("runningId") String runningId, Pageable pageable);

    @RestResource(path = "username")
    Page<RunningInformation> findByUserInfoUsername(@Param("username") String runningId, Pageable pageable);

    @Transactional
    void deleteByRunningId(@Param("runningId") String runningId);

}
