/*
@author :: Abhishek Gaurav
*/

package com.mockito.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
@Table(name = "user")
public class User {

    @Id()
    private int id;
    private String name;
    private int age;
    private String address;
}
