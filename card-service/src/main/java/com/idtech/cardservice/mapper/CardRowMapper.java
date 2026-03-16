package com.idtech.cardservice.mapper;

import com.idtech.cardservice.entity.Card;
import com.idtech.cardservice.model.enums.CardStatus;
import org.springframework.jdbc.core.RowMapper;

public class CardRowMapper {
    public static final RowMapper<Card> MAPPER = (rs, rowNum) ->
            Card.builder()
                    .id(rs.getLong("id"))
                    .holderName(rs.getString("holder_name"))
                    .pan(rs.getString("pan"))
                    .cvv(rs.getString("cvv"))
                    .expiryDate(rs.getDate("expiry_date").toLocalDate())
                    .balance(rs.getBigDecimal("balance"))
                    .status(CardStatus.valueOf(rs.getString("status")))
                    .build();
}
