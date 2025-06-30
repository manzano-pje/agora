package com.pjem.agora.record;

import com.pjem.agora.model.Board;

import java.time.LocalDate;

public record BoardResponse(
        LocalDate startDate,
        LocalDate finalDate,
        Boolean isActive
) {
    public BoardResponse(Board board) {
        this(
                board.getMandateStart(),
                board.getMandateEnd(),
                board.isActive()
        );
    }


}
