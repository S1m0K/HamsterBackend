package at.ac.htlinn.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@ToString
public class Error {

    private String error;
    private String message;
    private HttpStatus status;

}
