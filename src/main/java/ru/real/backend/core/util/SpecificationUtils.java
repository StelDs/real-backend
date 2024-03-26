package ru.real.backend.core.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class SpecificationUtils {

    public static final PageRequest PAGEABLE_MAX = PageRequest.of(0, 999999);

    private SpecificationUtils() {
    }

    public static <T, V> Specification<T> like(String field, V value, boolean isNeedNullValueCheck) {
        return nullValueCheck(value, isNeedNullValueCheck, (root, query, builder) -> {
            query.distinct(true);
            return builder.like(root.get(field), "%" + value + "%");
        });
    }

    public static <T, V> Specification<T> intensiveLike(String field, V value, boolean isNeedNullValueCheck) {
        return nullValueCheck(value, isNeedNullValueCheck, (root, query, builder) -> {
            query.distinct(true);
            return builder.like(builder.lower(root.get(field)), "%" + value.toString().toLowerCase() + "%");
        });
    }

    public static <T> Specification<T> isDeleted(String field, Boolean isDeleted) {
        if (TRUE.equals(isDeleted)) {
            return emptySpecification();
        }

        return SpecificationUtils.<T>isNull(field, TRUE, true)
                .or(SpecificationUtils.is(field, FALSE, true));
    }

    public static <T> Specification<T> isNull(String field, Boolean value, boolean isNeedNullValueCheck) {
        return nullValueCheck(Boolean.TRUE.equals(value) ? value : null, isNeedNullValueCheck, (root, query, builder) -> {
            query.distinct(false);
            return builder.isNull(root.get(field));
        });
    }

    public static <T, V> Specification<T> is(String field, V value, boolean isNeedNullValueCheck) {
        return nullValueCheck(value, isNeedNullValueCheck, (root, query, builder) -> {
            query.distinct(false);
            return builder.equal(root.get(field), value);
        });
    }


    private static <T, V> Specification<T> nullValueCheck(V value, boolean isNeedNullValueCheck, Specification<T> specification) {
        Specification<T> result;
        if (isNeedNullValueCheck && value == null) {
            result = emptySpecification();
        } else {
            result = specification;
        }
        return result;
    }

    public static <T> Specification<T> emptySpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> null;
    }
}
