package com.test.customerissue.service;

import com.test.customerissue.model.Issue;

import java.util.List;

public interface IssueService {
    public Issue saveIssue(Issue issue);
    public List<Issue> getAllIssues();
    public Issue getIssueById(Integer id);
    public void deleteIssue(Integer id);
    public Issue updateIssue(Integer id,Issue newIssue);
}
