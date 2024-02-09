package com.rs.retailstore.model;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Greeting {

    private long id;
    private String content;
}
