package org.example.infrastructure.rest.github;

import java.util.List;

public class Issue {
    String title;
    String body;
    List<String> assignees;
    int milestone;
    List<String> labels;
}
