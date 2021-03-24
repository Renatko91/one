package test.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.one.entity.ValCodeDaily;

public interface ValCodeDailyRepository extends JpaRepository<ValCodeDaily, String> {
    @Query("SELECT id FROM ValCodeDaily WHERE code in :code")
    String findIdByCode(String code);
}
