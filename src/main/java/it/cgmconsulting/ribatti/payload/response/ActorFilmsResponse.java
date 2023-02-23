package it.cgmconsulting.ribatti.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * <p> EP.10 </p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorFilmsResponse {
   private Long actorId;
   private List<FilmResponse> filmResponses;
}
