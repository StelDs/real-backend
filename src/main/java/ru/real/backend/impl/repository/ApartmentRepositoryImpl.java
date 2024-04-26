package ru.real.backend.impl.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.real.backend.api.dto.ApartmentPicHrefDto;
import org.springframework.stereotype.Repository;


import java.util.UUID;
import java.util.Optional;

@Repository
public class ApartmentRepositoryImpl implements JdbcApartmentRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public Optional<ApartmentPicHrefDto> findById(Long externalId) {


//        try {
//            var params = new MapSqlParameterSource();
//            params.addValue("externalId", externalId);
//
//            Optional<ApartmentPicHrefDto> a = jdbcTemplate.queryForObject(
//                    "select id, PIC_HREFS from reality.apartment where external_id = :id",
//                    params,
//                    (rs, rowNum) ->
//                            Optional.of(new ApartmentPicHrefDto(
//                                    UUID.fromString(rs.getString("id")),
//                                    rs.getString("PIC_HREFS")
//                            ))
//            );
//
//
//        } catch (Exception e) {
//            System.out.println("ОШИБКА : " + e.getMessage());
//        }


        Optional<ApartmentPicHrefDto> a2 = Optional.of(new ApartmentPicHrefDto(
                UUID.fromString("31119928-9100-4088-9cb8-c4085fa60aec"),
                "picHrefs"
        ));

        return a2;

    }
}
