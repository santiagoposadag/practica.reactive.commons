package com.santiagoposada.practicareactivecommons;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MessageToBotmaker {

    private String chatChannelNumber;
    private String recipientNumber;
    private String recipientName;
    private String message;
}
