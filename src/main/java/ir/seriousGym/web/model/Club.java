package ir.seriousGym.web.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@FieldDefaults(level=AccessLevel.PRIVATE)
@Table(name="clubs")
public class Club {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String title;
  private String photoUrl;
  private String content;
  
  @CreationTimestamp 
  private LocalDateTime createdOn;

  @UpdateTimestamp
  private LocalDateTime updateOn;

  @OneToMany(mappedBy="club", cascade=CascadeType.REMOVE) // when parent is removed chile will be too
  private List<Event> events = new ArrayList<>();

}
