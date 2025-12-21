package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String role;
    private boolean active = true;

    public Long getId() { 
        return id;
         }
    public String getEmail() { 
        return email;
         }
    public String getPassword() { 
        return password; 
        }
    public String getRole() {
         return role; 
         }
    public boolean isActive() { 
        return active; 
        }

    public void setId(Long id) {
         this.id = id;
          }
    public void setEmail(String email) {
         this.email = email; 
         }
    public void setPassword(String password) {
         this.password = password; 
         }
    public void setRole(String role) { 
        this.role = role; 
        }
    public void setActive(boolean active) { 
        this.active = active; 
        }
}
