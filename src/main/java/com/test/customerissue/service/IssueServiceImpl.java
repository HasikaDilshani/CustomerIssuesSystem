package com.test.customerissue.service;


import com.test.customerissue.model.Issue;
import com.test.customerissue.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public Issue saveIssue(Issue issue) {

        return issueRepository.save(issue);
    }

    @Override
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    @Override
    public Issue getIssueById(Integer id) {
        return issueRepository.findById(id).get();
    }

    @Override
    public void deleteIssue(Integer id) {
          issueRepository.deleteById(id);
        //return issue;
    }

    @Override
    public Issue updateIssue(Integer id,Issue newIssue) {
        return issueRepository.findById(id)
        .map(issue -> {
            issue.setCustomerId(newIssue.getCustomerId());
            issue.setCreatedDate(newIssue.getCreatedDate());
            issue.setState(newIssue.getState());
            issue.setDescription(newIssue.getDescription());
            issue.setType(newIssue.getType());
            return issueRepository.save(issue);
        })
                .orElseGet(() -> {
                    newIssue.setId(id);
                    return issueRepository.save(newIssue);
                });
    }
}
