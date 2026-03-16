package com.idtech.cardservice.repository;

import com.idtech.cardservice.entity.Card;
import com.idtech.cardservice.mapper.CardRowMapper;
import com.idtech.cardservice.model.enums.CardStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CardRepository {
    private final JdbcTemplate jdbcTemplate;

    public Card save(Card card) {
        String sql = """
                INSERT INTO cards (holder_name, pan, cvv, expiry_date, balance, status)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, card.getHolderName());
            ps.setString(2, card.getPan());
            ps.setString(3, card.getCvv());
            ps.setDate(4, Date.valueOf(card.getExpiryDate()));
            ps.setBigDecimal(5, card.getBalance());
            ps.setString(6, card.getStatus().toString());
            return ps;
        }, keyHolder);

        card.setId(((Number) keyHolder.getKeys().get("id")).longValue());
        return card;
    }

    public List<Card> findAll() {
        String sql = "select * from cards";
        return jdbcTemplate.query(sql, CardRowMapper.MAPPER);
    }

    public Optional<Card> findById(Long id) {
        String sql = "select * from cards where id=?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, CardRowMapper.MAPPER, id));
    }

    public int updateStatus(Long id, CardStatus status) {
        String sql = "UPDATE cards SET status = ? WHERE id = ?";
        return jdbcTemplate.update(sql, status.name(), id);
    }

    public int updateExpiryDate(Long id, java.time.LocalDate expiryDate) {
        String sql = "UPDATE cards SET expiry_date = ? WHERE id = ?";
        return jdbcTemplate.update(sql, Date.valueOf(expiryDate), id);
    }

    public int increaseBalance(Long id, BigDecimal amount) {
        String sql = "UPDATE cards SET balance = balance + ? WHERE id = ?";
        return jdbcTemplate.update(sql, amount, id);
    }
}
