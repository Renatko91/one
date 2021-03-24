package test.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.one.entity.ValRate;

import java.time.LocalDate;
import java.util.List;

public interface ValRateRepository extends JpaRepository<ValRate, String> {
    @Query("SELECT MAX(date) FROM ValRate")
    LocalDate getMaxDate();

    @Query("SELECT DISTINCT valcode_id FROM ValRate ORDER BY valcode_id")
    List<String> getCharCodeList();

    @Query("SELECT value FROM ValRate WHERE valcode_id in :valCodeId")
    String getValueByValCodeId(String valCodeId);
}
