package com.mallikarjun.demo.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EmployeeRequest {

private String name;

private List<String> department;
}
