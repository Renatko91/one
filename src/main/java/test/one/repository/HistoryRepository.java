package test.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.one.entity.History;

public interface HistoryRepository extends JpaRepository<History, String> {
}
