package demo.service;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunningInformationAnalysisImpl implements RunningInformationAnalysisService {

    private RunningInformationRepository runningInformationRepository;

    @Autowired
    public RunningInformationAnalysisImpl(RunningInformationRepository runningInformationRepository) {
        this.runningInformationRepository = runningInformationRepository;
    }
    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations) {
        return runningInformationRepository.save(runningInformations);
    }

    @Override
    public Page<RunningInformation> findByAll(Pageable pageable) {
        return runningInformationRepository.findAll(pageable);
    }

    @Override
    public Page<RunningInformation> findByRunningId(String runningId, Pageable pageable) {
        return runningInformationRepository.findByRunningId(runningId, pageable);
    }

    @Override
    public void deleteByRunningId(String runningId) {
        runningInformationRepository.deleteByRunningId(runningId);
    }

    @Override
    public Page<RunningInformation> findByUserInfoUsername(String username, Pageable pageable) {
        return runningInformationRepository.findByUserInfoUsername(username, pageable);
    }
}
