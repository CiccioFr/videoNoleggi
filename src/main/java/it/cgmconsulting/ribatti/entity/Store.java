package it.cgmconsulting.ribatti.entity;

import it.cgmconsulting.ribatti.payload.response.FilmInTimeResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * EP.4
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedNativeQuery(
        name = "Store.filmInTimeNativa",
        query = "SELECT s.store_name, COUNT(i.inventory_id) AS conteggio " +
                "    FROM Store AS s " +
                "    INNER JOIN Inventory AS i ON s.store_id = i.store_id " +
                "    INNER JOIN Rental AS r ON r.inventory_id = i.inventory_id " +
                "    WHERE s.store_id = :storeId " +
                "       AND r.rental_date BETWEEN CAST(:start AS DATE) AND CAST(:end AS DATE);",
        //"    WHERE s.store_id = :storeId AND r.rental_date > :start AND r.rental_return < :end;",
        resultSetMapping = "miaQuery"
)
@SqlResultSetMapping(
        name = "miaQuery",
        classes = @ConstructorResult(
                targetClass = FilmInTimeResponse.class,
                columns = {
                        @ColumnResult(name = "store_name", type = String.class),
                        @ColumnResult(name = "conteggio", type = Long.class)
                }
        )
)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storeId;

    @Column(length = 60, unique = true, nullable = false)
    private String storeName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return storeId == store.storeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId);
    }
}
