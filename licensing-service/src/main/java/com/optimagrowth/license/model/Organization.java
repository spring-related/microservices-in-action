package com.optimagrowth.license.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization extends RepresentationModel<Organization> {
    private String id;
    private String name;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
}
