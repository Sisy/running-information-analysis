package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInformationAnalysisService {
    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations);

    Page<RunningInformation> findByAll(Pageable pageable);

    Page<RunningInformation> findByRunningId(String runningId, Pageable pageable);

    void deleteByRunningId(String runningId);

    Page<RunningInformation> findByUserInfoUsername(String username, Pageable pageable);
}
