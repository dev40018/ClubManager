package ir.seriousGym.web.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClubDto {

  private Long id;
  @NotEmpty(message="Enter the title")
  private String title;
  @NotEmpty(message="Enter the photo url")
  private String photoUrl;
  @NotEmpty(message="Enter the content")
  private String content;
  private LocalDateTime createdOn;
  private LocalDateTime updateOn;

  private List<EventDto> events;

}
