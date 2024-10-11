package com.retrowalk.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.http.ResponseEntity;

import java.util.Date;

/**
 * The success response dto.
 *
 * @param <T> - The <T>
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"timeStamp", "statusCode", "message", "data"})
public class SuccessResponse<T> {

    /**
     * Data.
     * -- GETTER --
     * Get data.
     */
    T data;

    /**
     * Timestamp of response.
     * -- GETTER --
     * get Timestamp.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    Date timeStamp = new Date();

    /**
     * Status code.
     * -- GETTER --
     * Get status code.
     */
    Integer statusCode;

    /**
     * Status message.
     * -- GETTER --
     * Get message
     */
    String message;

    /**
     * Get response entity.
     *
     * @return ResponseEntity
     */
    @JsonIgnore
    public ResponseEntity<SuccessResponse<T>> getResponseEntity() {
        return ResponseEntity.ok(this);
    }
}
