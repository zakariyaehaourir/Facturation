package ma.ehei.facturation.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorResponse {
    private Instant timestamp = Instant.now();
    private String message;
}
