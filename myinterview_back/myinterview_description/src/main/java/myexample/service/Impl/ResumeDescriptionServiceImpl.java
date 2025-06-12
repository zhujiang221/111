package myexample.service.Impl;

import myexample.beans.Resume;
import myexample.mapper.ResumeDescriptionMapper;
import myexample.service.ResumeDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeDescriptionServiceImpl implements ResumeDescriptionService {
    @Autowired
    private ResumeDescriptionMapper mydescription;

    @Override
    public void updateDescription(Resume resume){
        mydescription.updateDescription(resume);
    }

}
