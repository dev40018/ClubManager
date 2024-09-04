package ir.seriousGym.web.dto;

import java.time.LocalDateTime;

import groovy.transform.builder.Builder;
import ir.seriousGym.web.model.Club;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
  private Long id;

  private String name;
  private LocalDateTime startTime;
  private LocalDateTime endtTime;
  private String type; // consider make it as an ENUM
  private String photoUrl;

  private LocalDateTime createdOn;

  private LocalDateTime updatedOn;


  private Club club;
}
