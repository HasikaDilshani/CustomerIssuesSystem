package com.test.customerissue.controller;

import com.test.customerissue.model.Issue;
import com.test.customerissue.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.*;

@RestController
@RequestMapping("/issue")
@CrossOrigin
public class IssueController {
    @Autowired
    private IssueService issueService;

    @PostMapping("/add")
    public String add(@RequestBody Issue issue){
        issueService.saveIssue(issue);
        return "New issue is added";
    }

    @GetMapping("/getAll")
    public List<Issue> getAllIssues(){
        return issueService.getAllIssues();
    }


    @GetMapping("/issues/{id}")
    public Issue getIssueById(@PathVariable(value = "id") Integer issueId) {
        return issueService.getIssueById(issueId);
                //.orElseThrow(() -> new ResourceNotFoundException("Note", "id", issueId));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIssue(@PathVariable(value = "id") Integer issueId) {
         issueService.deleteIssue(issueId);
    }


    @PutMapping("/updateIssue/{id}")
    public String replaceIssue(@RequestBody Issue newIssue,@PathVariable("id") Integer id) {

        issueService.updateIssue(id,newIssue);
        return "updated";
    }

}
