package com.telecom.mobileconnection.entity;
  
  import javax.persistence.Entity; 
  import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType; 
  import javax.persistence.Id; 
  import javax.persistence.Table;
  
  import lombok.Getter; import lombok.NoArgsConstructor; import lombok.Setter;
  
  @Entity
  @Table
  @Getter
  @Setter
  @NoArgsConstructor public class Plan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Integer planId;
  private String planDescription; 
  private String planType; 
  private Integer validity; 
  private Integer talktime; 
 private Double price;

  
  }
 