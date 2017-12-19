package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInformationAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInformationAnalysisController {

    private RunningInformationAnalysisService runningInformationAnalysisService;

    @Autowired
    public RunningInformationAnalysisController(RunningInformationAnalysisService runningInformationAnalysisService) {
        this.runningInformationAnalysisService = runningInformationAnalysisService;
    }

    @RequestMapping(value = "/runningInformation", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createRunningInformations(@RequestBody List<RunningInformation> runningInformations) {
        runningInformationAnalysisService.saveRunningInformation(runningInformations);
    }

    @RequestMapping(value = "/runningInformation", method = RequestMethod.GET)
    public Page<RunningInformation> queryRunningInformations(@RequestParam(name = "page") int page) {
       return runningInformationAnalysisService.findByAll(new PageRequest(page, 2, new Sort(Sort.Direction.DESC,  "healthWarningLevel")));
    }

    @RequestMapping(value = "/runningInformation/runningId/{runningId}", method = RequestMethod.GET)
    public Page<RunningInformation> queryRunningInformationsByRunningId(@PathVariable String runningId, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        return runningInformationAnalysisService.findByRunningId(runningId, new PageRequest(page, size));
    }

    @RequestMapping(value = "/runningInformation/runningId/{runningId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteByRunningId(@PathVariable String runningId) {
        runningInformationAnalysisService.deleteByRunningId(runningId);
    }

    @RequestMapping(value = "/runningInformation/username/{username}", method = RequestMethod.GET)
    public Page<RunningInformation> queryRunningInformationsByUserName(@PathVariable String username, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        return runningInformationAnalysisService.findByUserInfoUsername(username, new PageRequest(page, size, new Sort(Sort.Direction.DESC,  "healthWarningLevel")));
    }
}
